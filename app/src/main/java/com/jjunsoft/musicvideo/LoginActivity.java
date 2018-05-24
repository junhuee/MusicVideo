package com.jjunsoft.musicvideo;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;

import android.net.Uri;

import android.preference.PreferenceManager;
import android.support.annotation.NonNull;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.support.v7.widget.CardView;
import android.util.Base64;
import android.util.Log;

import android.view.View;

import android.widget.RelativeLayout;
import android.widget.Toast;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.Profile;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;

import org.json.JSONException;
import org.json.JSONObject;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class LoginActivity extends AppCompatActivity implements GoogleApiClient.OnConnectionFailedListener{
    //구글로그인
    GoogleSignInClient mGoogleSignInClient;
    public static final int RC_SIGN_IN = 9001;
    static GoogleApiClient mGoogleApiclient;
    String photo;
    SignInButton signInButton;

    //페이스북로그인
//    CallbackManager callbackManager;



    SharedPreferences.Editor editor;
    SharedPreferences pref;
    CardView logout;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        pref = PreferenceManager.getDefaultSharedPreferences(this);
        logout = findViewById(R.id.login_logout);
        signInButton = findViewById(R.id.sign_in_button);


        //페이스북로그인
//        FacebookSdk.sdkInitialize(this.getApplicationContext());
//        callbackManager = CallbackManager.Factory.create();
//
//
//        LoginButton loginButton = findViewById(R.id.login_button);
//        loginButton.setReadPermissions(Arrays.asList("public_profile","email"));
//
//        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
//            @Override
//            public void onSuccess(LoginResult loginResult) {
//
//
//
//                Thread  thread = new Thread(new Runnable() {
//                    @Override
//                    public void run() {
//
//                            Profile profile = Profile.getCurrentProfile();
//                            photo = profile.getProfilePictureUri(200,200).toString();
//
//                    }
//
//                });
//                thread.start();
//
//
//                GraphRequest graphRequest = GraphRequest.newMeRequest(loginResult.getAccessToken(), new GraphRequest.GraphJSONObjectCallback() {
//                    @Override
//                    public void onCompleted(JSONObject object, GraphResponse response) {
//                        Log.v("result",response.toString());
//
//                        try {
//                            String nickname = object.getString("name");
//                            String email = object.getString("email");
//
//
//                            J.userId = object.getString("name");
//                            J.userEmail = object.getString("email");
//                            Log.i("test300", "LoginActivity");
//                            J.userImg = photo;
//                            saveData(true);
//
//                            MemberDB load = new MemberDB(LoginActivity.this);
//                            load.loadDB(email,nickname,photo,0);
//
//
//                        } catch (JSONException e) {
//                            e.printStackTrace();
//                        }
//                    }
//                });
//                saveData(true);
//                Bundle parameters = new Bundle();
//                parameters.putString("fields","id,name,email,gender,birthday");
//                graphRequest.setParameters(parameters);
//                graphRequest.executeAsync();
//
//
//
//            }
//
//            @Override
//            public void onCancel() {
//
//
//            }
//
//            @Override
//            public void onError(FacebookException error) {
//
//                Log.e("LoginErr",error.toString());
//            }
//        });





        //구글 로그인
        SignInButton signInButton = findViewById(R.id.sign_in_button);

        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build();

        GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(this);

        if(account!=null){
            //로그인이 됬을때
            J.isLogin = true;

            saveData(true);
            J.userId = account.getDisplayName();
            J.userEmail = account.getEmail();
            Log.i("test300", "LoginActivity");
            J.userImg = account.getPhotoUrl().toString();

            logout.setVisibility(View.VISIBLE);
            signInButton.setVisibility(View.GONE);

            Log.i("qwer : ","Nic : " + J.userId+"Email : "+J.userEmail+"Img : " + J.userImg);
        }else {
            //로그인을 해야될대
            signInButton.setVisibility(View.VISIBLE);
            logout.setVisibility(View.GONE);



        }

            mGoogleApiclient = new GoogleApiClient.Builder(this).enableAutoManage(this,this).addApi(Auth.GOOGLE_SIGN_IN_API,gso).build();


        signInButton.setSize(SignInButton.SIZE_STANDARD);

        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent signInIntent = Auth.GoogleSignInApi.getSignInIntent(mGoogleApiclient);
                startActivityForResult(signInIntent, RC_SIGN_IN);
            }
        });

    }

//    private void printKeyHash() {
//        try{
//            PackageInfo info = getPackageManager().getPackageInfo("com.jjunsoft.musicvideo", PackageManager.GET_SIGNATURES);
//            for(Signature signature : info.signatures){
//                MessageDigest md = MessageDigest.getInstance("SHA");
//                md.update(signature.toByteArray());
//                Log.d("KeyHash", Base64.encodeToString(md.digest(),Base64.DEFAULT));
//            }
//
//        } catch (PackageManager.NameNotFoundException e) {
//            e.printStackTrace();
//        } catch (NoSuchAlgorithmException e) {
//            e.printStackTrace();
//        }
//
//    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == RC_SIGN_IN) {

            GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent(data);
            handleSignInResult(result);
        }




//        //페이스북
//        callbackManager.onActivityResult(requestCode,resultCode,data);
    }
    public void handleSignInResult(GoogleSignInResult result){

        Log.i("abcd",""+result.isSuccess());

        if(result.isSuccess()){
            J.isLogin=true;
            saveData(true);

            GoogleSignInAccount acct = result.getSignInAccount();
            String email = acct.getEmail();
            String nickname = acct.getDisplayName();
            Uri photouri = acct.getPhotoUrl();


            if(photouri!=null){
                photo = photouri.toString();
            }else {
                photo = " ";
            }
            Log.i("test1", "1: " + email + ", 2: " + nickname + ", 3: " + photo);

            J.userImg = acct.getPhotoUrl().toString();
            J.userId = acct.getDisplayName();
            J.userEmail = acct.getEmail();

            MemberDB load = new MemberDB(this);
            load.loadDB(email,nickname,photo,1);




        }else {
            Toast.makeText(this, "로그인 실패!", Toast.LENGTH_SHORT).show();
        }


    }


    public void clicklogout(View v){

        signOut();
        logout.setVisibility(View.GONE);
        signInButton.setVisibility(View.VISIBLE);
        J.userImg=null;
        J.userEmail=null;
        J.userId=null;
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
        finish();


    }



    public  void signOut(){
        Auth.GoogleSignInApi.signOut(mGoogleApiclient).setResultCallback(new ResultCallback<Status>() {
            @Override
            public void onResult(@NonNull Status status) {
                editor.putBoolean("Login",false);
                editor.commit();
            }
        });
    }
    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

        Log.i("abcde","connectionResult:"+connectionResult.getErrorMessage());

    }

    void saveData(boolean isLogin){

        editor = pref.edit();
        editor.putBoolean("Login",isLogin);
        editor.commit();

    }




}
