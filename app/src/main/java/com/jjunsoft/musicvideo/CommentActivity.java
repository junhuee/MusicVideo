package com.jjunsoft.musicvideo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ScrollView;

import java.util.ArrayList;

public class CommentActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    CommentRecyclerAdapter adapter;

    ArrayList<CommentItem> items = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment);

        Toolbar toolbar = findViewById(R.id.comment_toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        //데이터 추가


        recyclerView = findViewById(R.id.comment_Recycler);
        adapter = new CommentRecyclerAdapter(this,items);
        recyclerView.setAdapter(adapter);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);






    }
    public void clickCommentUp(View v){




    }
}
