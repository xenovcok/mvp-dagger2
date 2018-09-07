package com.bmt.zicreative.maidas.api;

import com.bmt.zicreative.maidas.booking.ShopService;
import com.bmt.zicreative.maidas.github.GithubService;
import com.bmt.zicreative.maidas.login.LoginService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

@Module
public class ServiceModule {

    @Provides
    @Singleton
    public ShopService provideShopService(Retrofit retrofit) {
        return retrofit.create(ShopService.class);
    }

    @Provides
    @Singleton
    public GithubService provideGithubService(Retrofit retrofit) {
        return retrofit.create(GithubService.class);
    }

    @Provides
    @Singleton
    public LoginService provideLoginService(Retrofit retrofit) {
        return retrofit.create(LoginService.class);
    }
}
