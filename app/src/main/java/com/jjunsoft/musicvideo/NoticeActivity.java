package com.jjunsoft.musicvideo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;

public class NoticeActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    NoticeRecyclerAdapter adapter;
    ArrayList<NoticeItem> items = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notice);


        Toolbar toolbar = findViewById(R.id.notice_toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);



        //데이터 추가


        recyclerView = findViewById(R.id.notice_Recycler);
        adapter = new NoticeRecyclerAdapter(this,items);
        recyclerView.setAdapter(adapter);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);



    }
}
