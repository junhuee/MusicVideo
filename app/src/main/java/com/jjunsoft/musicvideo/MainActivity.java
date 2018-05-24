package com.jjunsoft.musicvideo;

import android.*;
import android.Manifest;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends AppCompatActivity {


    NavigationView navigationView;
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle drawerToggle;
    TabLayout tabLayout;
    CategoryAdapter categoryAdapter;
    ViewPager pager;
    CircleImageView photo;
    TextView email;
    TextView nickname;
    SharedPreferences pref;
 



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pref = PreferenceManager.getDefaultSharedPreferences(this);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //외부저장소 읽고 쓰기 권한 퍼미션 체크 및 요청
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.M){
            if(checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE)== PackageManager.PERMISSION_DENIED){
                //허용안되어 있는상태이므로 다이얼로그 띄우기
                requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},100);
            }
        }




        tabLayout = findViewById(R.id.layout_tab);
        pager = findViewById(R.id.pager);

        categoryAdapter = new CategoryAdapter(getSupportFragmentManager());
        pager.setAdapter(categoryAdapter);
        tabLayout.setupWithViewPager(pager);

        drawerLayout = findViewById(R.id.drawer);
        navigationView = findViewById(R.id.nav);
        navigationView.setItemIconTintList(null);

        View header = navigationView.getHeaderView(0);

        photo = header.findViewById(R.id.nav_img);
        email = header.findViewById(R.id.nav_email);
        nickname = header.findViewById(R.id.nav_nickname);
        Glide.with(this).load(J.userImg).into(photo);
        nickname.setText(J.userId);
        email.setText(J.userEmail);
        Log.i("test300", "MainActivity");
        Log.i("aiaiaai","email  : "+J.userEmail);

        //네비게이션 메뉴 아이콘 클릭했을때
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){

                    case R.id.myProfile:
                        Intent profileActivity = new Intent(MainActivity.this,MyProfileActivity.class);
                        startActivity(profileActivity);
                        break;

                    case R.id.talk:
                        Intent talkActivity = new Intent(MainActivity.this,TalkActivity.class);
                        startActivity(talkActivity);

                        break;

                    case R.id.bookMark:
                        Intent bookActivity = new Intent(MainActivity.this,BookMarkActivity.class);
                        startActivity(bookActivity);
                        break;

                    case R.id.notice:
                        Intent noticeActivity = new Intent(MainActivity.this,NoticeActivity.class);
                        startActivity(noticeActivity);
                        break;


                }

                drawerLayout.closeDrawer(navigationView);
                return false;
            }
        });

        GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(this);
        if(account!=null){
            if(pref.getBoolean("Login",false)){
                nickname.setText(account.getDisplayName().toString());
                email.setText(account.getEmail().toString());
                Glide.with(this).load(account.getPhotoUrl().toString()).into(photo);

            }else {
                SharedPreferences.Editor editor = pref.edit();
                editor.putBoolean("Login",false);
                editor.commit();
            }
        }


        drawerToggle= new ActionBarDrawerToggle(this,drawerLayout,R.string.app_name,R.string.app_name);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        drawerToggle.syncState();
        drawerLayout.addDrawerListener(drawerToggle);

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        switch (requestCode){
            case 100:
                if(grantResults[0]==PackageManager.PERMISSION_DENIED){
                    Toast.makeText(this, "이미지 선택이 불가능 합니다!", Toast.LENGTH_SHORT).show();
                }
                break;
        }

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        drawerToggle.onOptionsItemSelected(item);
        return super.onOptionsItemSelected(item);
    }


    public void clickaddVideo(View v){

        if(pref.getBoolean("Login",false)){
            Intent intent = new Intent();
            intent.setAction(Intent.ACTION_PICK);
            intent.setType("video/*");
            startActivityForResult(intent,0);
        }else {
            Intent intent = new Intent(this,LoginActivity.class);
            startActivity(intent);
        }



    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode){
            case 0:
                if(resultCode==RESULT_OK){
                    Uri uri = data.getData();
                    if(uri!=null){

                        Intent intent = new Intent(this,AddVideoActivity.class);
                        intent.setData(uri);
                        startActivity(intent);

                    }
                }
                break;
        }


    }



}
