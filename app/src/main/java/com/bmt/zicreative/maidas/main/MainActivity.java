package com.bmt.zicreative.maidas.main;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.bmt.zicreative.maidas.R;
import com.bmt.zicreative.maidas.api.NetworkModule;
import com.bmt.zicreative.maidas.api.ServiceModule;

import javax.inject.Inject;

import dagger.android.AndroidInjection;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    @Inject
    ServiceModule serviceModule;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);
    }

    public void onLoadData() {

    }

}
