package com.bmt.zicreative.maidas.register;

import com.bmt.zicreative.maidas.Utils.AuthenticationUtil;
import com.bmt.zicreative.maidas.api.ApiResponse;
import com.bmt.zicreative.maidas.api.UserService;
import com.bmt.zicreative.maidas.base.BasePresenter;
import com.bmt.zicreative.maidas.login.LoginService;
import com.bmt.zicreative.maidas.models.Authenticate;
import com.bmt.zicreative.maidas.models.User;

import javax.inject.Inject;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created By Herwin DJ on 10/23/2018
 **/

public class RegisterPresenter extends BasePresenter implements RegisterContract.Presenter {

    private UserService userService;
    private RegisterContract.View view;
    private String message;

    @Inject
    public RegisterPresenter(UserService userService, RegisterContract.View view) {
        this.userService = userService;
        this.view = view;
    }

    @Override
    protected void onViewDestroy() {

    }

    @Override
    public void addUser(User user) {
        userService.saveUser(user)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ApiResponse>() {
                    @Override
                    public void onCompleted() {
                        view.onSuccess(message);
                    }

                    @Override
                    public void onError(Throwable e) {
                        view.onFailure("Register gagal");
                    }

                    @Override
                    public void onNext(ApiResponse apiResponse) {
                        message = apiResponse.getMessage();
                    }
                });
    }
}
