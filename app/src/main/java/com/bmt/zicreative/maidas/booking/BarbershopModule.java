package com.bmt.zicreative.maidas.booking;

import dagger.Binds;
import dagger.Module;

/**
 * Created By Herwin DJ on 7/24/2018
 **/

@Module
public interface BarbershopModule {

    @Binds
    BookingContract.View provideBookingView(BookingActivity bookingActivity);

    @Binds
    BookingContract.Presenter provideBookingPresenter(BarbershopPresenter barbershopPresenter);

}
