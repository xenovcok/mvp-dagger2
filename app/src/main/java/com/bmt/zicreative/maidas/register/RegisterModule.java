package com.bmt.zicreative.maidas.register;

import dagger.Binds;
import dagger.Module;

/**
 * Created By Herwin DJ on 10/23/2018
 **/

@Module
public interface RegisterModule {

    @Binds
    abstract RegisterContract.View provideRegisterView(RegisterActivity registerActivity);

    @Binds
    abstract RegisterContract.Presenter provideRegisterPresenter(RegisterPresenter registerPresenter);
}
