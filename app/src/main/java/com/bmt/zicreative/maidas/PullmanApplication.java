package com.bmt.zicreative.maidas;

import android.app.Application;

import com.bmt.zicreative.maidas.di.AppComponent;
import com.bmt.zicreative.maidas.di.DaggerAppComponent;

public class PullmanApplication extends Application {
    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = DaggerAppComponent.builder().application(this).build();
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }
}
