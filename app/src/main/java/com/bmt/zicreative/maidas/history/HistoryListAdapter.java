package com.bmt.zicreative.maidas.history;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bmt.zicreative.maidas.R;
import com.bmt.zicreative.maidas.models.BookingOrder;

import java.util.List;
import java.util.zip.Inflater;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created By Herwin DJ on 9/5/2018
 **/

public class HistoryListAdapter extends RecyclerView.Adapter<HistoryListAdapter.ListViewHolder> {

    private List<BookingOrder> dataList;
    private Context context;

    public HistoryListAdapter(List<BookingOrder> dataList, Context context) {
        this.dataList = dataList;
        this.context = context;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_history,parent,false);

        return new ListViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {
        holder.tvHistoryBarberman.setText(dataList.get(position).getBarbermanId());
        holder.tvHistoryBookDate.setText(dataList.get(position).getBookForDate());
        holder.tvHistoryBookId.setText(dataList.get(position).getBookId());
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_history_book_id)
        TextView tvHistoryBookId;

        @BindView(R.id.tv_history_barberman)
        TextView tvHistoryBarberman;

        @BindView(R.id.tv_history_book_date)
        TextView tvHistoryBookDate;

        public ListViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
