package com.bmt.zicreative.maidas.booking;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bmt.zicreative.maidas.R;
import com.bmt.zicreative.maidas.booking.barberman.BarberActivity;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created By Herwin DJ on 7/20/2018
 **/

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.BookViewHolder>{

    private List<BarbershopModel> barbershopModel;
    private Context context;

    public BookAdapter(Context context,List<BarbershopModel> barbershopModel) {
        this.barbershopModel = new ArrayList<>();
        this.barbershopModel = barbershopModel;
        this.context = context;
    }

    @NonNull
    @Override
    public BookViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.booking_item, parent, false);

        return new BookViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull BookViewHolder bookViewHolder, int position) {
        Log.d("data adapter", this.barbershopModel.get(position).getName());

        Glide.with(context).load(this.barbershopModel.get(position).getPhoto()).into(bookViewHolder.ivPhoto);
        bookViewHolder.itemTitleTv.setText(this.barbershopModel.get(position).getName());
        bookViewHolder.tvDesc.setText(this.barbershopModel.get(position).getDescription());
        bookViewHolder.tvLocation.setText(this.barbershopModel.get(position).getAddress());
        bookViewHolder.shopItem.setOnClickListener(view -> {
            Intent intent = new Intent(context, BarberActivity.class);
            intent.putExtra("shop", this.barbershopModel.get(position).getId());
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return this.barbershopModel.size();
    }

    public class BookViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.shop_item_image)
        ImageView ivPhoto;

        @BindView(R.id.shop_item_desc)
        TextView tvDesc;

        @BindView(R.id.shop_item_location)
        TextView tvLocation;

        @BindView(R.id.shop_item_title)
        public TextView itemTitleTv;

        @BindView(R.id.shop_item)
        LinearLayoutCompat shopItem;

        public BookViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
