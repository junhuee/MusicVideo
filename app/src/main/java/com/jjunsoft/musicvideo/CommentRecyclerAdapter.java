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

public class CommentRecyclerAdapter extends RecyclerView.Adapter {

    Context context;
    ArrayList<CommentItem> items;

    public CommentRecyclerAdapter(Context context, ArrayList<CommentItem> items) {
        this.context = context;
        this.items = items;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View itemView = inflater.inflate(R.layout.comment_item,parent,false);

        VH holder = new VH(itemView);

        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        VH vh = (VH)holder;

        CommentItem item = items.get(position);

        vh.commentUserId.setText(item.commentId);
        vh.commentUserContents.setText(item.commentContents);

    }

    @Override
    public int getItemCount() {
        return items.size();
    }



    class VH extends RecyclerView.ViewHolder{

    TextView commentUserId;
    TextView commentUserContents;

        public VH(View itemView) {
            super(itemView);

            commentUserId = itemView.findViewById(R.id.comment_userId);
            commentUserContents = itemView.findViewById(R.id.commnet_userContents);
        }
    }
}
