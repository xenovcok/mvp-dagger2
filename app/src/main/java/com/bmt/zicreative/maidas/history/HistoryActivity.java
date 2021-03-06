package com.bmt.zicreative.maidas.history;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.widget.Adapter;
import android.widget.Toolbar;

import com.bmt.zicreative.maidas.R;
import com.bmt.zicreative.maidas.base.BaseActivity;
import com.bmt.zicreative.maidas.base.BasePresenter;
import com.bmt.zicreative.maidas.booking.BookingActivity;
import com.bmt.zicreative.maidas.main.MainActivity;
import com.bmt.zicreative.maidas.models.BookingOrder;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import dagger.android.AndroidInjection;

public class HistoryActivity extends BaseActivity implements HistoryContract.View {

    HistoryListAdapter adapter;
    List<BookingOrder> bookingOrderList;

    @Inject
    HistoryPresenter historyPresenter;

    @BindView(R.id.rv_history_list)
    RecyclerView rvHistoryList;

    @Override
    protected void bindData() {

    }

    @Override
    public int getLayout() {
        return R.layout.activity_history;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if(id == android.R.id.home) {
            startActivity(new Intent(HistoryActivity.this, MainActivity.class));
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void setup() {
        AndroidInjection.inject(this);
        setTitleToolbar("History");
        showBackIconToolbar(true);
        setAdapterLayoutManager();
        initData();
    }

    private void setAdapterLayoutManager() {
        rvHistoryList.setLayoutManager(new LinearLayoutManager(this));
    }

    private void initData() {
        bookingOrderList = new ArrayList<>();
        historyPresenter.getAllOrder("andi@gmail.com");
    }


    private void initAdapter() {
        adapter = new HistoryListAdapter(bookingOrderList, this);
        rvHistoryList.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    @Override
    public BasePresenter attachPresenter() {
        return historyPresenter;
    }

    @Override
    public void onSuccess(String message) {

    }

    @Override
    public void onFailed(String message) {

    }

    @Override
    public void onGetDataSuccess(List<BookingOrder> data) {
        this.bookingOrderList.addAll(data);
        initAdapter();
    }
}
