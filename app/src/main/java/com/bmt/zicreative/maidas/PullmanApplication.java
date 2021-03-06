package com.bmt.zicreative.maidas;

import android.app.Activity;
import android.app.Application;

import com.bmt.zicreative.maidas.di.AppComponent;
import com.bmt.zicreative.maidas.di.DaggerAppComponent;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;

public class PullmanApplication extends Application implements HasActivityInjector {
    private static PullmanApplication instance;

    @Inject
    DispatchingAndroidInjector<Activity> activityDispatchingAndroidInjector;

    @Override
    public void onCreate() {
        super.onCreate();
        initDagger();
    }

    public PullmanApplication() {
        instance = this;
    }

    private void initDagger() {
        DaggerAppComponent
                .builder()
                .application(this)
                .build()
                .inject(this);
    }

    @Override
    public AndroidInjector<Activity> activityInjector() {
        return activityDispatchingAndroidInjector;
    }

    public static PullmanApplication getInstace() {
        return instance;
    }
}
