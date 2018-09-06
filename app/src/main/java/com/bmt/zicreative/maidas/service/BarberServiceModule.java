package com.bmt.zicreative.maidas.service;

import dagger.Binds;
import dagger.Module;

/**
 * Created By Herwin DJ on 9/6/2018
 **/

@Module
public interface BarberServiceModule {

    @Binds
    BarberServiceContract.View provideBarberServiceView(BarberServiceActivity barberServiceActivity);

    @Binds
    BarberServiceContract.Presenter provideBarberServicePresenter(BarberServicePresenter barberServicePresenter);

}
