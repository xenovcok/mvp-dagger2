package com.bmt.zicreative.maidas.main;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bmt.zicreative.maidas.R;
import com.bmt.zicreative.maidas.booking.BookingActivity;
import com.bmt.zicreative.maidas.github.GithubActivity;
import com.bmt.zicreative.maidas.history.HistoryActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created By Herwin DJ on 7/26/2018
 **/

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MainViewHolder> {

    private Context context;
    private List<MenuItem> menuItem = new ArrayList<>();

    public MainAdapter(Context context) {
        this.context = context;
       // this.menuItem = menuItem;
    }

    public void addAll(List<MenuItem> dataItems) {
        menuItem.addAll(dataItems);
    }

    @Override
    public MainViewHolder onCreateViewHolder(ViewGroup viewGroup, int position) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_dashboard_menu, viewGroup, false);
        MainViewHolder mainViewHolder = new MainViewHolder(v);
        return mainViewHolder;
    }

    @Override
    public void onBindViewHolder(MainViewHolder mainViewHolder, int position) {
        mainViewHolder.ivMenu.setImageResource(menuItem.get(position).getImage());
        mainViewHolder.tvTitle.setText(menuItem.get(position).getTitle());
        mainViewHolder.ivMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (position) {
                    case 0 :
                        context.startActivity(new Intent(context, GithubActivity.class));
                        break;
                    case 1 :
                        context.startActivity(new Intent(context, GithubActivity.class));
                        break;
                    case 2 :
                        context.startActivity(new Intent(context, HistoryActivity.class));
                        break;
                    case 3 :
                        context.startActivity(new Intent(context, BookingActivity.class));
                        break;
                    case 4 :
                        context.startActivity(new Intent(context, GithubActivity.class));
                        break;
                    case 5 :
                        context.startActivity(new Intent(context, GithubActivity.class));
                        break;
                }

            }
        });
    }

    @Override
    public int getItemCount() {
        return menuItem.size();
    }

    public class MainViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.iv_dashboard_menu)
        ImageView ivMenu;

        @BindView(R.id.tv_title_menu)
        TextView tvTitle;

        public MainViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
