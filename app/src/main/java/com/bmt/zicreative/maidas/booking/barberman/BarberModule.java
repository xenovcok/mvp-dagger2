package com.bmt.zicreative.maidas.booking.barberman;

import dagger.Binds;
import dagger.Module;

/**
 * Created By Herwin DJ on 8/1/2018
 **/

@Module
public interface BarberModule {

    @Binds
    BarberContract.View provideBarberView(BarberActivity barberActivity);

    @Binds
    BarberContract.Presenter provideBarberPresenter(BarberPresenter barberPresenter);
}
