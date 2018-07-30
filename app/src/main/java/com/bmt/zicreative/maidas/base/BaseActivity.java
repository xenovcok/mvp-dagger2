package com.bmt.zicreative.maidas.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.bmt.zicreative.maidas.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    private Unbinder unbinder;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        findViews();
        setToolbar();
        setup();
        bindData();
    }

    private void setToolbar() {
        if (toolbar != null) {
            Log.d("toolbar not null : ", "True");
            setSupportActionBar(toolbar);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setDisplayShowTitleEnabled(false);
        }
    }

    protected abstract void bindData();
    

    private void findViews() {
        if(0 != getLayout()) {
            setContentView(getLayout());
            unbinder = ButterKnife.bind(this);
        }
    }

    public abstract int getLayout();

    public abstract void setup();

    @Override
    protected void onDestroy() {
        if(unbinder != null) {
            unbinder.unbind();
        }

        if(attachPresenter() != null) {
            attachPresenter().onViewDestroy();
        }

        super.onDestroy();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if(id == R.id.item_info) {

        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(newBase);
    }

    public abstract BasePresenter attachPresenter();

    protected void showBackIconToolbar(boolean isEnable) {
        if (toolbar != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(isEnable);
        }
    }

    protected void showMenuIconToolbar() {
        if (toolbar != null) {
            getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_menu);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    protected void setTitleToolbar(String title) {
        if (toolbar != null) {
            getSupportActionBar().setDisplayShowTitleEnabled(true);
            getSupportActionBar().setTitle(title);
        }
    }

}
