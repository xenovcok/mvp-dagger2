package com.bmt.zicreative.maidas.login;

import com.bmt.zicreative.maidas.Utils.AuthenticationUtil;
import com.bmt.zicreative.maidas.base.BasePresenter;
import com.bmt.zicreative.maidas.models.Authenticate;

import javax.inject.Inject;

import io.reactivex.subscribers.ResourceSubscriber;
import rx.android.schedulers.AndroidSchedulers;

/**
 * Created By Herwin DJ on 9/7/2018
 **/

public class LoginPresenter extends BasePresenter implements LoginContract.Presenter {

    private final LoginService loginService;
    private final LoginContract.View view;
    private final AuthenticationUtil authenticationUtil;

    @Inject
    public LoginPresenter(LoginService loginService, LoginContract.View view, AuthenticationUtil authenticationUtil) {
        this.loginService = loginService;
        this.view = view;
        this.authenticationUtil = authenticationUtil;
    }

    @Override
    protected void onViewDestroy() {

    }

    @Override
    public void login(String username, String password) {
        loginService.authenticate(username, password)
                .subscribeOn(io.reactivex.schedulers.Schedulers.newThread())
                .observeOn(io.reactivex.android.schedulers.AndroidSchedulers.mainThread())
                .subscribe(new ResourceSubscriber<Authenticate>() {
                    @Override
                    public void onNext(Authenticate authenticate) {
                        if(authenticate != null) {
                            authenticationUtil.registerAuthentication(authenticate);
                        }
                    }

                    @Override
                    public void onError(Throwable t) {
                        view.onLoginFailed(t.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        view.onLoginSuccess();
                    }
                });
    }
}
