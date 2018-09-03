package com.bmt.zicreative.maidas.booking.service;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.bmt.zicreative.maidas.R;
import com.bmt.zicreative.maidas.base.BaseActivity;
import com.bmt.zicreative.maidas.base.BasePresenter;
import com.bmt.zicreative.maidas.booking.detail.DetailActivity;
import com.bmt.zicreative.maidas.models.Product;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import dagger.android.AndroidInjection;

/**
 * Created By Herwin DJ on 8/9/2018
 **/

public class ServiceActivity extends BaseActivity implements ServiceContract.View, ServiceItemAdapter.CheckedData {

    ServiceItemAdapter adapter;

    @BindView(R.id.service_recycleview)
    RecyclerView rvService;

    @BindView(R.id.btn_book)
    AppCompatButton btnBook;

    @Inject
    ServicePresenter servicePresenter;

    List<Product> productList;
    List<Product> checkedItem;
    int total;
    ArrayList<String> itemIdList;


    @Override
    protected void bindData() {
    }

    @Override
    public int getLayout() {
        return R.layout.activity_service;
    }

    @Override
    public void setup() {
        AndroidInjection.inject(this);
        showBackIconToolbar(true);
        setTitleToolbar("Pilih Layanan");
        initRecycleViewManager();
        initData();

    }

    private void initRecycleViewManager() {
        rvService.setLayoutManager(new LinearLayoutManager(this));
    }

    private void initData() {
        servicePresenter.findAllProducts();
    }

    private void initView() {
        Log.d("DEBUG", "initData: " + productList.get(0).getId());
        adapter = new ServiceItemAdapter(ServiceActivity.this, this.productList);
        rvService.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        adapter.setListener(this);
        btnBook.setOnClickListener(view -> {
            Intent p = getIntent();
            setItemIdList();
            Intent i = new Intent(ServiceActivity.this, DetailActivity.class);
            Log.d("DEBUG","Data From Adapter : "+checkedItem.size());
            i.putStringArrayListExtra("serviceItem", itemIdList);
            i.putExtra("barberId", p.getStringExtra("barberId"));
            i.putExtra("shopId", p.getStringExtra("shopId"));
            i.putExtra("bookingDate", p.getStringExtra("bookingDate"));
            i.putExtra("total", total);
            Log.d("DEBUG","Total from Activity : "+total);
            startActivity(i);
        });
    }

    @Override
    public BasePresenter attachPresenter() {
        return servicePresenter;
    }

    @Override
    public void onGetDataSuccess(List<Product> productList) {
        this.productList = new ArrayList<>();
        this.checkedItem = new ArrayList<>();
        this.itemIdList = new ArrayList<>();
        this.productList.addAll(productList);
        initView();
    }

    @Override
    public void onGetDataFailed(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onCheckboxClick(List<Product> product, int total) {
       this.checkedItem = product;
       this.total = total;
    }

    private void setItemIdList() {
        for(int i = 0;i < checkedItem.size();i++) {
            itemIdList.add(checkedItem.get(i).getId());
            Log.d("DEBUG", "setItemIdList: "+checkedItem.get(i).getId());
        }

    }
}
