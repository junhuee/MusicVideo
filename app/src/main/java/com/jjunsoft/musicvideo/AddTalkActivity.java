package com.jjunsoft.musicvideo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class AddTalkActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_talk);
    }

    public void clickOk(View v){


    }

    public void clickCancel(View v){

        finish();

    }
}
