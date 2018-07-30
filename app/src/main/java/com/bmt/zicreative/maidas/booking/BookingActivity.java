package com.bmt.zicreative.maidas.booking;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.bmt.zicreative.maidas.R;
import com.bmt.zicreative.maidas.base.BaseActivity;
import com.bmt.zicreative.maidas.base.BasePresenter;
import com.bmt.zicreative.maidas.main.MainActivity;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import dagger.android.AndroidInjection;

public class BookingActivity extends BaseActivity implements BookingContract.View {

    BookAdapter bookAdapter;

    List<BarbershopModel> barbershopModels;

    @Inject
    BarbershopPresenter barbershopPresenter;

    @BindView(R.id.book_recycleview)
    RecyclerView rvBook;

    @Override
    protected void bindData() {

    }

    @Override
    public int getLayout() {
        return R.layout.activity_booking;
    }

    @Override
    public void setup() {
        AndroidInjection.inject(this);
        ButterKnife.bind(this);
        setTitleToolbar("Booking");
        initRecycleViewLayoutManager();
        initData();
    }

    private void initData() {
        barbershopModels = new ArrayList<>();
        barbershopPresenter.getData();
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
        Log.d("tes data", barbershopModel.get(1).getName());
        this.barbershopModels.addAll(barbershopModel);
        initAdapter(barbershopModel);
    }

    @Override
    public void onLoadFailed(String message) {

    }

    @Override
    public void onLoadSuccess(String message) {
       Toast.makeText(this,message,Toast.LENGTH_LONG).show();
    }

    private void initAdapter(List<BarbershopModel> data) {
        Log.d("debug data : ",data.get(0).getName());
        bookAdapter = new BookAdapter(BookingActivity.this,data);
        rvBook.setAdapter(bookAdapter);
        bookAdapter.notifyDataSetChanged();
    }
}
