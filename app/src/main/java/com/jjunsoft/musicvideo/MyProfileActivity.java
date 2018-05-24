package com.jjunsoft.musicvideo;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;

import de.hdodenhof.circleimageview.CircleImageView;

public class MyProfileActivity extends AppCompatActivity {


    CircleImageView profilePhoto;
    TextView profileNickname;
    TextView profileEmail;
    TextView login;
    SharedPreferences pref;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_profile);

        Toolbar toolbar = findViewById(R.id.profile_toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        profilePhoto = findViewById(R.id.profile_photo);
        profileNickname = findViewById(R.id.profile_nickname);
        profileEmail = findViewById(R.id.profile_email);

        login = findViewById(R.id.myProfile_login);

        pref = PreferenceManager.getDefaultSharedPreferences(this);
        editor= pref.edit();



        GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(this);
        if(account!=null){
            if(pref.getBoolean("Login",false)){
                profileNickname.setText(account.getDisplayName().toString());
                profileEmail.setText(account.getEmail().toString());
                Glide.with(this).load(account.getPhotoUrl().toString()).into(profilePhoto);

            }else {
                SharedPreferences.Editor editor = pref.edit();
                editor.putBoolean("Login",false);
                editor.commit();
            }
        }


    }


    public void clickMyvideo(View v){

        Intent myVideo = new Intent(this,MyVideoActivity.class);
        startActivity(myVideo);

    }

    public void clickLogin(View v){

            Intent login = new Intent(this,LoginActivity.class);
            login.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(login);

            J.isLogin=true;

    }


    public void clickLogout(View v){



    }

    public void clickSecession(View v){

        Toast.makeText(this, "탈퇴", Toast.LENGTH_SHORT).show();

    }



}
