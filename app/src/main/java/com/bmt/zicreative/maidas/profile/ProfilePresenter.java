package com.bmt.zicreative.maidas.profile;

import com.bmt.zicreative.maidas.Utils.AuthenticationUtil;
import com.bmt.zicreative.maidas.base.BasePresenter;

import javax.inject.Inject;

/**
 * Created By Herwin DJ on 10/11/2018
 **/

public class ProfilePresenter extends BasePresenter implements ProfileContract.Presenter{

    private final AuthenticationUtil authenticationUtil;
    private final ProfileContract.View view;

    @Inject
    public ProfilePresenter(AuthenticationUtil authenticationUtil, ProfileContract.View view) {
        this.authenticationUtil = authenticationUtil;
        this.view = view;
    }

    @Override
    protected void onViewDestroy() {

    }

    @Override
    public void logout() {
        authenticationUtil.logout();
        view.onLogout();
    }
}
