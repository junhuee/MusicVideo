package com.jjunsoft.musicvideo;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.ArrayList;

public class TalkActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    TalkRecyclerAdapter adapter;

    ArrayList<TalkItem> items = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_talk);

        Toolbar toolbar = findViewById(R.id.talk_toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        //데이터 추가작업

        items.add(new TalkItem("주니","ㅁㅇ너리마나ㅓㄹSADFASDFASDFASDFASFDASDFASDFASDFASDF","2018-19-20"));
        items.add(new TalkItem("짱구","ㅁㅇ너리마나ㅓㄹSADFASDFASDFASDFASFDASDFASDFASDFASDF","2018-19-20"));
        items.add(new TalkItem("쌤","ㅁㅇ너리마나ㅓㄹSADFASDFASDFASDFASFDASDFASDFASDFASDF","2018-19-20"));
        items.add(new TalkItem("로빈","ㅁㅇ너리마나ㅓㄹSADFASDFASDFASDFASFDASDFASDFASDFASDF","2018-19-20"));
        items.add(new TalkItem("그냥","ㅁㅇ너리마나ㅓㄹSADFASDFASDFASDFASFDASDFASDFASDFASDF","2018-19-20"));
        items.add(new TalkItem("바가","ㅁㅇ너리마나ㅓㄹSADFASDFASDFASDFASFDASDFASDFASDFASDF","2018-19-20"));


        recyclerView = findViewById(R.id.talk_Recycler);
        adapter = new TalkRecyclerAdapter(this,items);
        recyclerView.setAdapter(adapter);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);





    }

    public void clickaddTalk(View v){

        Intent addtalk = new Intent(this,AddTalkActivity.class);
        startActivity(addtalk);


    }

}
