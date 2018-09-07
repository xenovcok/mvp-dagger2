package com.bmt.zicreative.maidas.login;

import com.bmt.zicreative.maidas.base.BasePresenter;

import javax.inject.Inject;

import retrofit2.Retrofit;

/**
 * Created By Herwin DJ on 9/7/2018
 **/

public class LoginPresenter extends BasePresenter implements LoginContract.Presenter {

    private final LoginService loginService;
    private final LoginContract.View view;

    @Inject
    public LoginPresenter(LoginService loginService, LoginContract.View view) {
        this.loginService = loginService;
        this.view = view;
    }

    @Override
    protected void onViewDestroy() {

    }

    @Override
    public void login(String username, String password) {
        loginService.authenticate(username, password);
    }
}
