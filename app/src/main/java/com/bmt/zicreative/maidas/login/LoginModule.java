package com.bmt.zicreative.maidas.login;

import dagger.Binds;
import dagger.Module;

/**
 * Created By Herwin DJ on 9/7/2018
 **/

@Module
public interface LoginModule {
    @Binds
    abstract LoginContract.View provideLoginView(LoginActivity loginActivity);

    @Binds
    abstract  LoginContract.Presenter provideLoginPresenter(LoginPresenter loginPresenter);
}
