package com.bmt.zicreative.maidas.main;

import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.bmt.zicreative.maidas.R;
import com.bmt.zicreative.maidas.base.BaseActivity;
import com.bmt.zicreative.maidas.base.BasePresenter;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.InstanceIdResult;
import com.google.firebase.messaging.FirebaseMessaging;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import dagger.android.AndroidInjection;

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
    public boolean onOptionsItemSelected(android.view.MenuItem item) {
        switch (item.getItemId()) {
            case R.id.logout:
                Log.d("DEBUG", "onOptionsItemSelected: "+item.getItemId());
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public int getLayout() {
        return R.layout.main_activity;
    }

    @Override
    public void setup() {
        AndroidInjection.inject(this);
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

        FirebaseMessaging.getInstance().subscribeToTopic("PROMOTION");
    }

    @Override
    public BasePresenter attachPresenter() {
        return null;
    }

    private void initMenuData() {

    }

}
