package com.bmt.zicreative.maidas.booking;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.bmt.zicreative.maidas.PullmanApplication;
import com.bmt.zicreative.maidas.R;
import com.bmt.zicreative.maidas.api.NetworkModule;
import com.bmt.zicreative.maidas.api.ServiceModule;
import com.bmt.zicreative.maidas.base.BaseActivity;
import com.bmt.zicreative.maidas.base.BasePresenter;

import java.util.List;

import javax.inject.Inject;

import dagger.android.AndroidInjection;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

public class BookingActivity extends BaseActivity implements BookingContract.View {

    @Inject
    BarbershopPresenter barbershopPresenter;

    @Override
    public int getLayout() {
        return R.layout.activity_booking;
    }

    @Override
    public void setup() {
        AndroidInjection.inject(this);
    }

    @Override
    public BasePresenter attachPresenter() {
        return barbershopPresenter;
    }

    @Override
    public void onLoadData(BarbershopModel barbershopModel) {
        initAdapter();
    }

    @Override
    public void onLoadFailed(String message) {
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onLoadSuccess(String message) {
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
    }

    private void initAdapter() {

    }
}
