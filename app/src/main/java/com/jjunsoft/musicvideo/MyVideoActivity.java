package com.jjunsoft.musicvideo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;

public class MyVideoActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    MyVideoRecyclerAdapter adapter;
    ArrayList<MyVideoItem> items = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_video);

        Toolbar toolbar = findViewById(R.id.myVideo_toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        //데이터추가

        items.add(new MyVideoItem("ㅋㅋㅋ","2018-12-12",1,1,"ㅇㅇㅇ"));




        recyclerView = findViewById(R.id.myVideo_Recycler);
        adapter = new MyVideoRecyclerAdapter();
        recyclerView.setAdapter(adapter);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

    }
}
