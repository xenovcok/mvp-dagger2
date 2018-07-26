package com.bmt.zicreative.maidas.booking;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bmt.zicreative.maidas.R;

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
        bookViewHolder.itemTitleTv.setText(this.barbershopModel.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return this.barbershopModel.size();
    }

    public class BookViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.shop_item_title)
        public TextView itemTitleTv;

        public BookViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
