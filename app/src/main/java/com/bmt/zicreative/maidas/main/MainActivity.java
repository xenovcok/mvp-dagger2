package com.bmt.zicreative.maidas.main;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.bmt.zicreative.maidas.R;
import com.bmt.zicreative.maidas.api.NetworkModule;
import com.bmt.zicreative.maidas.api.ServiceModule;
import com.bmt.zicreative.maidas.base.BaseActivity;
import com.bmt.zicreative.maidas.base.BasePresenter;

import javax.inject.Inject;

import dagger.android.AndroidInjection;
import retrofit2.Retrofit;

public class MainActivity extends BaseActivity implements MainContract.View {

    @Inject
    MainPresenter presenter;

    @Override
    public int getLayout() {
        return R.layout.main_activity;
    }

    @Override
    public void setup() {

    }

    @Override
    public BasePresenter attachPresenter() {
        return presenter;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
