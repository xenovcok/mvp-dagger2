package com.bmt.zicreative.maidas.main;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bmt.zicreative.maidas.R;
import com.bmt.zicreative.maidas.base.BaseActivity;
import com.bmt.zicreative.maidas.base.BasePresenter;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;

public class MainActivity extends BaseActivity {

    List<MenuItem> menuItems = new ArrayList<>();

    @BindView(R.id.iv_promo_main)
    ImageView ivPromoMain;

    @BindView(R.id.dashboard_recycleview)
    RecyclerView rcDashboard;

    @Override
    protected void bindData() {

    }

    @Override
    public int getLayout() {
        return R.layout.main_activity;
    }

    @Override
    public void setup() {
        showMenuIconToolbar();
        setTitleToolbar("Pullman Barbershop");

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2, LinearLayout.VERTICAL, false);
        rcDashboard.setLayoutManager(gridLayoutManager);

        initMenuData();

        MainAdapter adapter = new MainAdapter(this);
        rcDashboard.setAdapter(adapter);

        Glide.with(this).load(R.drawable.alt_promo).apply(new RequestOptions().fitCenter()).into(ivPromoMain);

        menuItems.add(new MenuItem(R.drawable.ic_account_circle, "My Account"));
        menuItems.add(new MenuItem(R.drawable.ic_card, "My Voucher"));
        menuItems.add(new MenuItem(R.drawable.ic_history, "History"));
        menuItems.add(new MenuItem(R.drawable.ic_booking, "Booking"));
        menuItems.add(new MenuItem(R.drawable.ic_service, "Servis"));
        menuItems.add(new MenuItem(R.drawable.ic_inbox, "Inbox"));

        adapter.addAll(menuItems);
        adapter.notifyDataSetChanged();
    }

    @Override
    public BasePresenter attachPresenter() {
        return null;
    }

    private void initMenuData() {

    }

}
