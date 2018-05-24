package com.jjunsoft.musicvideo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class DetailTalkActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_talk);

        Toolbar toolbar = findViewById(R.id.detailTalk_toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }


    public void clickcomment(View v){

        Intent intent = new Intent(this,CommentActivity.class);
        startActivity(intent);

    }
}
