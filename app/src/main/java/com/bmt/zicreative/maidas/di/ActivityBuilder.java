package com.bmt.zicreative.maidas.di;

import com.bmt.zicreative.maidas.api.NetworkModule;
import com.bmt.zicreative.maidas.booking.BarbershopModule;
import com.bmt.zicreative.maidas.booking.BookingActivity;
import com.bmt.zicreative.maidas.booking.avaliability.AvailabilityActivity;
import com.bmt.zicreative.maidas.booking.avaliability.AvailabilityModule;
import com.bmt.zicreative.maidas.booking.barberman.BarberActivity;
import com.bmt.zicreative.maidas.booking.barberman.BarberModule;
import com.bmt.zicreative.maidas.booking.detail.DetailActivity;
import com.bmt.zicreative.maidas.booking.detail.DetailModule;
import com.bmt.zicreative.maidas.booking.service.ItemServiceModule;
import com.bmt.zicreative.maidas.booking.service.ServiceActivity;
import com.bmt.zicreative.maidas.github.GithubActivity;
import com.bmt.zicreative.maidas.github.GithubModule;
import com.bmt.zicreative.maidas.history.HistoryActivity;
import com.bmt.zicreative.maidas.history.HistoryModule;
import com.bmt.zicreative.maidas.inbox.InboxActivity;
import com.bmt.zicreative.maidas.inbox.InboxModule;
import com.bmt.zicreative.maidas.login.LoginActivity;
import com.bmt.zicreative.maidas.login.LoginModule;
import com.bmt.zicreative.maidas.main.MainActivity;
import com.bmt.zicreative.maidas.profile.ProfileActivity;
import com.bmt.zicreative.maidas.profile.ProfileModule;
import com.bmt.zicreative.maidas.register.RegisterActivity;
import com.bmt.zicreative.maidas.register.RegisterModule;
import com.bmt.zicreative.maidas.service.BarberServiceActivity;
import com.bmt.zicreative.maidas.service.BarberServiceModule;

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

    @ContributesAndroidInjector(modules = {NetworkModule.class, BarberModule.class})
    abstract BarberActivity bindBarberActivity();

    @ContributesAndroidInjector(modules = {NetworkModule.class, AvailabilityModule.class})
    abstract AvailabilityActivity bindAvailabiliyActivity();

    @ContributesAndroidInjector(modules = {NetworkModule.class, ItemServiceModule.class})
    abstract ServiceActivity bindServiceActivity();

    @ContributesAndroidInjector(modules = {DetailModule.class})
    abstract DetailActivity bindDetailActivity();

    @ContributesAndroidInjector(modules = {HistoryModule.class})
    abstract HistoryActivity bindHistoryActivity();

    @ContributesAndroidInjector(modules = {NetworkModule.class, BarberServiceModule.class})
    abstract BarberServiceActivity bindBarberServiceActivity();

    @ContributesAndroidInjector(modules = {LoginModule.class})
    abstract LoginActivity bindLoginActivity();

    @ContributesAndroidInjector(modules = {ProfileModule.class})
    abstract ProfileActivity bindProfileActivity();

    @ContributesAndroidInjector(modules = {RegisterModule.class})
    abstract RegisterActivity bindRegisterActivity();

    @ContributesAndroidInjector(modules = {InboxModule.class})
    abstract InboxActivity bindInboxActivity();
}
