package com.bmt.zicreative.maidas.inbox;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bmt.zicreative.maidas.R;

/**
 * Created By Herwin DJ on 10/29/2018
 **/

public class InboxListViewAdapter extends RecyclerView.Adapter<InboxListViewAdapter.InboxViewHolder> {

    Context context;

    public InboxListViewAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public InboxViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.inbox_item,parent,false);
        return new InboxViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull InboxViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class InboxViewHolder extends RecyclerView.ViewHolder {
        public InboxViewHolder(View itemView) {
            super(itemView);
        }
    }
}
