package com.bmt.zicreative.maidas.booking.service;

import dagger.Binds;
import dagger.Module;

/**
 * Created By Herwin DJ on 8/9/2018
 **/

@Module
public interface ItemServiceModule {

    @Binds
    ServiceContract.View provideServiceView(ServiceActivity serviceActivity);

    @Binds
    ServiceContract.Presenter provideServicePresener(ServicePresenter servicePresenter);
}
