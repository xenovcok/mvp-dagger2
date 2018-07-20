package com.bmt.zicreative.maidas.di;

import com.bmt.zicreative.maidas.api.NetworkModule;
import com.bmt.zicreative.maidas.booking.BookingActivity;
import com.bmt.zicreative.maidas.main.MainActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract  class ActivityBuilder {

    @ContributesAndroidInjector
    abstract MainActivity bindMainActivity();

    @ContributesAndroidInjector(modules = NetworkModule.class)
    abstract BookingActivity bindBookingActivity();
}
