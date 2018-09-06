package com.bmt.zicreative.maidas.service;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bmt.zicreative.maidas.R;
import com.bmt.zicreative.maidas.models.Product;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created By Herwin DJ on 9/6/2018
 **/

public class BarberServiceListAdapter extends RecyclerView.Adapter<BarberServiceListAdapter.BarberServiceViewHolder>{

    private List<Product> products;
    private Context context;

    public BarberServiceListAdapter(List<Product> products, Context context) {
        this.products = new ArrayList<>();
        this.products = products;
        this.context = context;
    }

    @NonNull
    @Override
    public BarberServiceViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_barber_service,parent, false);
        return new BarberServiceViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull BarberServiceViewHolder holder, int position) {
        holder.tvBarberItemId.setText(products.get(position).getId());
        holder.tvBarberServiceName.setText(products.get(position).getName());
        holder.tvBarberServicePrice.setText(products.get(position).getPrice());
    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    public class BarberServiceViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.barber_service_item_id)
        TextView tvBarberItemId;

        @BindView(R.id.barber_service_name)
        TextView tvBarberServiceName;

        @BindView(R.id.barber_service_price)
        TextView tvBarberServicePrice;

        public BarberServiceViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
