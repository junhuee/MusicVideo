package com.jjunsoft.musicvideo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;

public class BookMarkActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    BookMarkRecyclerAdapter adapter;
    ArrayList<BookMarkItem> items = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_mark);

        Toolbar toolbar = findViewById(R.id.bookmark_toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        //데이터 추가






        recyclerView = findViewById(R.id.bookMark_Recycler);
        adapter = new BookMarkRecyclerAdapter(this,items);
        recyclerView.setAdapter(adapter);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
    }
}
