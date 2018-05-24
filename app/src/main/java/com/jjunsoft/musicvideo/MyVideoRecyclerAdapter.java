package com.jjunsoft.musicvideo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by alfo06-05 on 2018-05-01.
 */

public class MyVideoRecyclerAdapter extends RecyclerView.Adapter {

    Context context;
    ArrayList<MyVideoItem> items = new ArrayList<>();

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(context);
        View itmeView = inflater.inflate(R.layout.myvideo_item,parent,false);

        VH holder = new VH(itmeView);

        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        VH vh = (VH)holder;
        MyVideoItem item = items.get(position);

        vh.title.setText(item.title);
        vh.date.setText(item.date);
        vh.goodNum.setText(item.goodNum+"");
        vh.playNum.setText(item.playNum+"");

    }

    @Override
    public int getItemCount() {
        return items.size();
    }


    class VH extends RecyclerView.ViewHolder{

        TextView title;
        TextView date;
        TextView goodNum;
        TextView playNum;
        ImageView img;


        public VH(View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.myVideo_title);
            date = itemView.findViewById(R.id.myVideo_date);
            goodNum = itemView.findViewById(R.id.myVideo_goodNumber);
            playNum = itemView.findViewById(R.id.myVideo_playerNumber);
            img = itemView.findViewById(R.id.myVideo_img);




        }
    }




}
