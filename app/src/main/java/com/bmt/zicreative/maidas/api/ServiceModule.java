package com.bmt.zicreative.maidas.api;

import com.bmt.zicreative.maidas.booking.ShopService;

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
}
