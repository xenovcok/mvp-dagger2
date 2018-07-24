package com.bmt.zicreative.maidas.booking;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.bmt.zicreative.maidas.R;
import com.bmt.zicreative.maidas.base.BaseActivity;
import com.bmt.zicreative.maidas.base.BasePresenter;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import dagger.android.AndroidInjection;

public class BookingActivity extends BaseActivity implements BookingContract.View {

    BookAdapter bookAdapter;

    List<BarbershopModel> barbershopModels;

    @Inject
    BarbershopPresenter barbershopPresenter;

    @BindView(R.id.book_recycleview)
    RecyclerView rvBook;

    @Override
    public int getLayout() {
        return R.layout.activity_booking;
    }

    @Override
    public void setup() {
        AndroidInjection.inject(this);
        initRecycleViewLayoutManager();
        initAdapter();
    }

    private void initRecycleViewLayoutManager() {
        rvBook.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public BasePresenter attachPresenter() {
        return barbershopPresenter;
    }

    @Override
    public void onLoadData(List<BarbershopModel> barbershopModel) {
        this.barbershopModels.addAll(barbershopModel);
        bookAdapter.notifyDataSetChanged();
    }

    @Override
    public void onLoadFailed(String message) {
        Toast.makeText(this,message,Toast.LENGTH_LONG).show();
    }

    @Override
    public void onLoadSuccess(String message) {
        Toast.makeText(this,message,Toast.LENGTH_LONG).show();
    }

    private void initAdapter() {
        bookAdapter = new BookAdapter(barbershopModels);
        rvBook.setAdapter(bookAdapter);
    }
}
