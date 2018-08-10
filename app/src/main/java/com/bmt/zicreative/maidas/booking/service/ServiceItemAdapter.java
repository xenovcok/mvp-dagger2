package com.bmt.zicreative.maidas.booking.service;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.bmt.zicreative.maidas.R;
import com.bmt.zicreative.maidas.models.Product;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created By Herwin DJ on 8/9/2018
 **/

public class ServiceItemAdapter extends RecyclerView.Adapter<ServiceItemAdapter.ServiceViewHolder>{

    Context context;
    private List<Product> productList;
    private List<Product> checkedBox = new ArrayList<>();
    private CheckedData checkedData;

    public ServiceItemAdapter(Context context, List<Product> productList) {
        this.productList = new ArrayList<>();
        this.context = context;
        this.productList = productList;
    }

    @NonNull
    @Override
    public ServiceItemAdapter.ServiceViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_service, parent, false);
        return new ServiceViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ServiceItemAdapter.ServiceViewHolder holder, int position) {
        holder.tvItemId.setText(this.productList.get(position).getId());
        holder.tvItemName.setText(this.productList.get(position).getName());
        holder.tvPrice.setText(this.productList.get(position).getPrice());
        holder.cbItem.setChecked(false);
        holder.cbItem.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b) {
                    checkedBox.add(productList.get(position));
                }else{
                    checkedBox.remove(productList.get(position));
                }
                Log.d("DEBUG", "checkedbox size : "+checkedBox.size());
                checkedData.onCheckboxClick(checkedBox);
            }
        });
    }

    @Override
    public int getItemCount() {
        return this.productList.size();
    }



    public class ServiceViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.item_id)
        TextView tvItemId;

        @BindView(R.id.service_name)
        TextView tvItemName;

        @BindView(R.id.price)
        TextView tvPrice;

        @BindView(R.id.service_checkbox)
        CheckBox cbItem;

        public ServiceViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public void setListener(CheckedData checkedData) {
        this.checkedData = checkedData;
    }

    public interface CheckedData {
        void onCheckboxClick(List<Product> product);
    }
}
