package com.bmt.zicreative.maidas.booking.detail;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bmt.zicreative.maidas.R;
import com.bmt.zicreative.maidas.models.Product;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created By Herwin DJ on 9/4/2018
 **/

public class DetailListItemAdapter extends RecyclerView.Adapter<DetailListItemAdapter.ItemListViewHolder> {

    Context context;
    List<Product> productList;

    public DetailListItemAdapter(Context context, List<Product> productList) {
        this.productList = new ArrayList<>();
        this.context = context;
        this.productList = productList;
    }

    @NonNull
    @Override
    public ItemListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.booking_detail_item, parent, false);
        return new ItemListViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemListViewHolder holder, int position) {
        holder.tvDetailItemName.setText(productList.get(position).getName());
        holder.tvDetailItemPrice.setText("Rp. "+productList.get(position).getPrice());
    }

    @Override
    public int getItemCount() {
        return this.productList.size();
    }

    public class ItemListViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.item_name)
        TextView tvDetailItemName;

        @BindView(R.id.item_price)
        TextView tvDetailItemPrice;

        public ItemListViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
