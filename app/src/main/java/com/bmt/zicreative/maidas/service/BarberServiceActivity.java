package com.bmt.zicreative.maidas.service;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;

import com.bmt.zicreative.maidas.R;
import com.bmt.zicreative.maidas.base.BaseActivity;
import com.bmt.zicreative.maidas.base.BasePresenter;
import com.bmt.zicreative.maidas.booking.avaliability.AvailabilityActivity;
import com.bmt.zicreative.maidas.booking.service.ServiceActivity;
import com.bmt.zicreative.maidas.main.MainActivity;
import com.bmt.zicreative.maidas.models.Product;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import dagger.android.AndroidInjection;

public class BarberServiceActivity extends BaseActivity implements BarberServiceContract.View {

    BarberServiceListAdapter adapter;

    List<Product> productList;

    @Inject
    BarberServicePresenter barberServicePresenter;

    @BindView(R.id.rv_barber_service_list)
    RecyclerView rvBarberServiceList;

    @Override
    protected void bindData() {

    }

    @Override
    public int getLayout() {
        return R.layout.activity_barber_service;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if(id == android.R.id.home) {
            startActivity(new Intent(BarberServiceActivity.this, MainActivity.class));
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void setup() {
        AndroidInjection.inject(this);
        showBackIconToolbar(true);
        setTitleToolbar("Pullman Service");
        setRecycleViewLayoutManager();
        initData();
    }

    private void setRecycleViewLayoutManager() {
        rvBarberServiceList.setLayoutManager(new LinearLayoutManager(this));
    }

    private void initData() {
        barberServicePresenter.findAllProduct();
    }

    private void initView() {
        adapter = new BarberServiceListAdapter(productList, BarberServiceActivity.this);
        rvBarberServiceList.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    @Override
    public BasePresenter attachPresenter() {
        return barberServicePresenter;
    }

    @Override
    public void onSuccess(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onFailed(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onGetDataSuccess(List<Product> product) {
        this.productList = new ArrayList<>();
        this.productList.addAll(product);
        initView();
    }
}
