package com.bmt.zicreative.maidas.main;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;

import com.bmt.zicreative.maidas.R;
import com.bmt.zicreative.maidas.base.BaseActivity;
import com.bmt.zicreative.maidas.base.BasePresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {

    List<MenuItem> menuItems = new ArrayList<>();

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

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        rcDashboard.setLayoutManager(gridLayoutManager);

        initMenuData();

        MainAdapter adapter = new MainAdapter(this);
        rcDashboard.setAdapter(adapter);

        menuItems.add(new MenuItem(R.drawable.ic_account_circle, "My Account"));
        menuItems.add(new MenuItem(R.drawable.ic_history, "History"));
        menuItems.add(new MenuItem(R.drawable.ic_booking, "Booking"));
        menuItems.add(new MenuItem(R.drawable.ic_service, "Servis"));
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
