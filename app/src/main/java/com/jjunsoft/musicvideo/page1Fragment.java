package com.jjunsoft.musicvideo;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by alfo06-05 on 2018-03-21.
 */

public class page1Fragment extends Fragment {

    Context context;
    RecyclerView recyclerView;
    Page1Adapter adapter;

    ArrayList<Page1Item> items = new ArrayList<>();


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {




        View view = inflater.inflate(R.layout.page1fragment,container,false);

        recyclerView = view.findViewById(R.id.page1_recycler);

        context = getContext();
        adapter = new Page1Adapter(context,items);
        recyclerView.setAdapter(adapter);


        return view;

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        intDataset();

    }

    public void intDataset(){
        items.add(new Page1Item("노래노래","18-03-21",10,10,true,"dd"));
        items.add(new Page1Item("노래노래","18-03-22",1,1,true,"dd"));
        items.add(new Page1Item("노래노래","18-03-23",1,1,true,"dd"));
        items.add(new Page1Item("노래노래","18-03-24",1,1,true,"dd"));
        items.add(new Page1Item("노래노래","18-03-25",1,1,true,"dd"));
        items.add(new Page1Item("노래노래","18-03-26",1,1,true,"dd"));
        items.add(new Page1Item("노래노래","18-03-27",1,1,true,"dd"));
        items.add(new Page1Item("노래노래","18-03-28",1,1,true,"dd"));
        items.add(new Page1Item("노래노래","18-03-29",1,1,true,"dd"));
        items.add(new Page1Item("노래노래","18-03-21",1,1,true,"dd"));
        items.add(new Page1Item("노래노래","18-03-21",1,1,true,"dd"));
        items.add(new Page1Item("노래노래","18-03-21",1,1,true,"dd"));
        items.add(new Page1Item("노래노래","18-03-21",1,1,true,"dd"));


    }




}
