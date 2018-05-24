package com.jjunsoft.musicvideo;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by alfo06-05 on 2018-04-25.
 */

public class TalkRecyclerAdapter extends RecyclerView.Adapter {

    Context context;
    ArrayList<TalkItem> items;

    public TalkRecyclerAdapter(Context context, ArrayList<TalkItem> items) {
        this.context = context;
        this.items = items;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View itemView = inflater.inflate(R.layout.talkrecycler_item,parent,false);

        VH holder = new VH(itemView);


        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        VH vh = (VH)holder;

        TalkItem item = items.get(position);

        vh.talkUserId.setText(item.id);
        vh.talkUserContents.setText(item.contents);
        vh.talkDate.setText(item.date);

    }

    @Override
    public int getItemCount() {
        return items.size();
    }


    class VH extends RecyclerView.ViewHolder{

        TextView talkUserId;
        TextView talkUserContents;
        TextView talkDate;

        public VH(View itemView) {
            super(itemView);

            talkUserId = itemView.findViewById(R.id.talk_userId);
            talkUserContents = itemView.findViewById(R.id.talk_userContents);
            talkDate = itemView.findViewById(R.id.talk_date);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Intent detailtalk = new Intent(context,DetailTalkActivity.class);

                    context.startActivity(detailtalk);

                }
            });

        }
    }

}
