package com.jjunsoft.musicvideo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ToggleButton;

import java.util.ArrayList;

/**
 * Created by alfo06-05 on 2018-03-21.
 */

public class Page1Adapter extends RecyclerView.Adapter {

    Context context;
    ArrayList<Page1Item> items;



    public Page1Adapter(Context context, ArrayList<Page1Item> items) {
        this.context = context;
        this.items = items;


    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    //recycler_page01item.xml을 view객체로 만드는작업
        LayoutInflater inflater = LayoutInflater.from(context);
        View itemView = inflater.inflate(R.layout.recycler_page01item,parent,false);

        VH holder = new VH(itemView);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        VH vh = (VH)holder;

        Page1Item item= items.get(position);

        vh.title.setText(item.title);
        vh.day.setText(item.day);
        vh.good.setText(item.good+"");
        vh.player.setText(item.player+"");



    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    class VH extends RecyclerView.ViewHolder{

        TextView title;
        TextView day;
        TextView good;
        TextView player;
        ImageView videoImg;
        ToggleButton bookm;
        LinearLayout clickVideo;



        public VH(View itemView) {
            super(itemView);

            clickVideo=itemView.findViewById(R.id.clickVideo);

            title = itemView.findViewById(R.id.re_item_title);
            day = itemView.findViewById(R.id.re_item_day);
            good = itemView.findViewById(R.id.re_item_good_num);
            player = itemView.findViewById(R.id.re_item_player_num);
            videoImg = itemView.findViewById(R.id.re_item_video);
            bookm = itemView.findViewById(R.id.re_item_bookmark);


        }



    }



}
