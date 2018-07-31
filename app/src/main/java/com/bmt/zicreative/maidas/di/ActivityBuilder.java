package com.bmt.zicreative.maidas.di;

import com.bmt.zicreative.maidas.api.NetworkModule;
import com.bmt.zicreative.maidas.booking.BarbershopModule;
import com.bmt.zicreative.maidas.booking.BookingActivity;
import com.bmt.zicreative.maidas.github.GithubActivity;
import com.bmt.zicreative.maidas.github.GithubModule;
import com.bmt.zicreative.maidas.main.MainActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract  class ActivityBuilder {

    @ContributesAndroidInjector(modules = NetworkModule.class)
    abstract MainActivity bindMainActivity();

    @ContributesAndroidInjector(modules = {NetworkModule.class, BarbershopModule.class})
    abstract BookingActivity bindBookingActivity();

    @ContributesAndroidInjector(modules = {NetworkModule.class, GithubModule.class})
    abstract GithubActivity bindGithubActivity();
}
