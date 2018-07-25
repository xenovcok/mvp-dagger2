package com.bmt.zicreative.maidas.base;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;

import butterknife.ButterKnife;

/**
 * Created By Herwin DJ on 7/25/2018
 **/

public abstract class BaseViewHolder<T> extends RecyclerView.ViewHolder  {
    private final Context context;

    private final View view;

    public BaseViewHolder(Context context, View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
        this.view = itemView;
        this.context = context;
    }

    public void setOnClickListener(final OnItemClickListener onClickListener) {
        if(view != null && onClickListener != null) {
            view.setOnClickListener(v -> onClickListener.onItemClick(getAdapterPosition()));
        }
    }

    public Context getContext() {
        return context;
    }

    public abstract void bindData(T data);

    public interface OnItemClickListener {
        void onItemClick(int position);
    }
}
