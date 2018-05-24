package com.jjunsoft.musicvideo;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by alfo06-05 on 2018-03-15.
 */

public class IntroActivity extends AppCompatActivity {

    ImageView iv;

    Timer timer = new Timer();

    //내부저장소에 저장
    SharedPreferences pref;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intro_activity);

        //내부저장소에 저장
        pref = PreferenceManager.getDefaultSharedPreferences(this);


        iv = findViewById(R.id.iv);

        Animation ani = AnimationUtils.loadAnimation(this,R.anim.appear_intro);
        iv.startAnimation(ani);


        timer.schedule(task, 3000);
        Log.i("eeeeeeeeee",J.isLogin+"");

        loadData();



    }//onCreate...

    TimerTask task = new TimerTask() {
        @Override
        public void run() {
            Intent intent = new Intent(IntroActivity.this,MainActivity.class);
            startActivity(intent);

            finish();
        }
    };

    void loadData(){

        J.isLogin = pref.getBoolean("Login",false);


    }


}//MainClass..
