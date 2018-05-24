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
 * Created by alfo06-05 on 2018-05-01.
 */

public class BookMarkRecyclerAdapter extends RecyclerView.Adapter {
    Context context;
    ArrayList<BookMarkItem> items;

    public BookMarkRecyclerAdapter(Context context, ArrayList<BookMarkItem> items) {
        this.context = context;
        this.items = items;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View itemView = inflater.inflate(R.layout.bookmark_item,parent,false);

        VH holder = new VH(itemView);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        VH vh = (VH)holder;

        BookMarkItem item = items.get(position);

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
        ImageView videoImg;
        ToggleButton bookm;

        public VH(View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.bookMak_title);
            date = itemView.findViewById(R.id.bookMark_date);
            goodNum = itemView.findViewById(R.id.bookMark_goodNumber);
            playNum = itemView.findViewById(R.id.bookMark_playerNumber);
            videoImg = itemView.findViewById(R.id.bookMark_img);
            bookm = itemView.findViewById(R.id.bookMark_bookmark);

        }
    }
}
