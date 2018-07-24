package com.bmt.zicreative.maidas.booking;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bmt.zicreative.maidas.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created By Herwin DJ on 7/20/2018
 **/

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.BookViewHolder>{

    private List<BarbershopModel> barbershopModel;

    public BookAdapter(List<BarbershopModel> barbershopModel) {
        this.barbershopModel = barbershopModel;
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
        BarbershopModel shopData = barbershopModel.get(position);
        bookViewHolder.itemTitleTv.setText(shopData.getName());
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class BookViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.shop_item_title)
        public TextView itemTitleTv;

        public BookViewHolder(@NonNull View itemView) {
            super(itemView);

        }
    }
}
