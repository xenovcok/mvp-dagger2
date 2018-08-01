package com.bmt.zicreative.maidas.booking.barberman;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bmt.zicreative.maidas.R;
import com.bmt.zicreative.maidas.models.Barber;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created By Herwin DJ on 8/1/2018
 **/

public class BarberAdapter extends RecyclerView.Adapter<BarberAdapter.BarberViewHolder> {

    private Context context;
    private List<Barber> barberList;

    public BarberAdapter(Context context, List<Barber> barberList) {
        this.barberList = new ArrayList<>();
        this.barberList = barberList;
        this.context = context;
    }

    @NonNull
    @Override
    public BarberViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.barber_item,parent, false);

        return new BarberViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BarberViewHolder holder, int position) {
        holder.ivProfilePhoto.setImageResource(R.drawable.ic_account_circle);
        holder.tvName.setText(barberList.get(position).getName());
        holder.tvDesc.setText("Experienced barber from Pullman");
    }

    @Override
    public int getItemCount() {
        return this.barberList.size();
    }

    public class BarberViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.barber_item_image)
        ImageView ivProfilePhoto;

        @BindView(R.id.barber_item_name)
        TextView tvName;

        @BindView(R.id.barber_item_desc)
        TextView tvDesc;

        public BarberViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
