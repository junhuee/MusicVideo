package com.jjunsoft.musicvideo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by alfo06-05 on 2018-05-01.
 */

public class NoticeRecyclerAdapter extends RecyclerView.Adapter {

    Context context;
    ArrayList<NoticeItem> items;

    public NoticeRecyclerAdapter(Context context, ArrayList<NoticeItem> items) {
        this.context = context;
        this.items = items;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(context);
        View itemView = inflater.inflate(R.layout.noticerecycler_item,parent,false);

        VH holder = new VH(itemView);

        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        VH vh = (VH)holder;

        NoticeItem item = items.get(position);
        vh.noticeContents.setText(item.contents);
        vh.noticeDate.setText(item.date);

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    class VH extends RecyclerView.ViewHolder{

        TextView noticeContents;
        TextView noticeDate;

        public VH(View itemView) {
            super(itemView);

            noticeContents = itemView.findViewById(R.id.notice_Contents);
            noticeDate = itemView.findViewById(R.id.notice_date);

        }
    }

}
