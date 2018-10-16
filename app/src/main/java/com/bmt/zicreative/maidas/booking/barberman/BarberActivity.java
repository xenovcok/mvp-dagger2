package com.bmt.zicreative.maidas.booking.barberman;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;

import com.bmt.zicreative.maidas.R;
import com.bmt.zicreative.maidas.base.BaseActivity;
import com.bmt.zicreative.maidas.base.BasePresenter;
import com.bmt.zicreative.maidas.booking.BookingActivity;
import com.bmt.zicreative.maidas.main.MainActivity;
import com.bmt.zicreative.maidas.models.Barber;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import dagger.android.AndroidInjection;

/**
 * Created By Herwin DJ on 8/1/2018
 **/

public class BarberActivity extends BaseActivity implements BarberContract.View {

    BarberAdapter adapter;
    List<Barber> barberList;

    @Inject
    BarberPresenter barberPresenter;

    @BindView(R.id.barber_recycleview)
    RecyclerView recBarber;

    @Override
    protected void bindData() {

    }

    @Override
    public int getLayout() {
        return R.layout.barber_activity;
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void setup() {
        AndroidInjection.inject(this);
        setTitleToolbar("Available Barber");
        showBackIconToolbar(true);
        initLayoutManager();
        initData();
    }

    @Override
    public BasePresenter attachPresenter() {
        return barberPresenter;
    }

    @Override
    public void onGetDataSuccess(List<Barber> barber) {
        this.barberList.addAll(barber);
        //Log.d("BARBER DATA : ", this.barberList.get(1).getName());
        initAdapter();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if(id == android.R.id.home) {
            startActivity(new Intent(BarberActivity.this, BookingActivity.class));
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onGetDataError(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

    private void initLayoutManager() {
        recBarber.setLayoutManager(new LinearLayoutManager(this));
    }

    private void initData() {
        this.barberList = new ArrayList<>();
        barberPresenter.getData();
    }

    private void  initAdapter() {
        adapter = new BarberAdapter(BarberActivity.this, this.barberList);
        recBarber.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

}
