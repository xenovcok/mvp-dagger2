package com.bmt.zicreative.maidas.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseActivity extends AppCompatActivity {

    private Unbinder unbinder;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        findViews();
        setup();
    }

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
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(newBase);
    }

    public abstract BasePresenter attachPresenter();


}
