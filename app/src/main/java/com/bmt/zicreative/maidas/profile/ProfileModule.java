package com.bmt.zicreative.maidas.profile;

import dagger.Binds;
import dagger.Module;

/**
 * Created By Herwin DJ on 10/11/2018
 **/
@Module
public interface ProfileModule {
    @Binds
    abstract ProfileContract.Presenter provideProfilePresenter(ProfilePresenter profilePresenter);

    @Binds
    abstract ProfileContract.View provideProfileView(ProfileActivity profileActivity);
}
