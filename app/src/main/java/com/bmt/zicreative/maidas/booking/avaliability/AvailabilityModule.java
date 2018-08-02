package com.bmt.zicreative.maidas.booking.avaliability;

import dagger.Binds;
import dagger.Module;

/**
 * Created By Herwin DJ on 8/2/2018
 **/

@Module
public interface AvailabilityModule {

    @Binds
    AvailabilityContract.View provideAvailabilityView(AvailabilityActivity availabilityActivity);

    @Binds
    AvailabilityContract.Presenter provideAvailabilityPresenter(AvailabilityPresenter availabilityPresenter);
}
