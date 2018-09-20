package com.bmt.zicreative.maidas.login;

/**
 * Created By Herwin DJ on 9/7/2018
 **/

public interface LoginContract {
    interface View {
        void onLoginFailed(String message);
        void onLoginSuccess();
    }

    interface Presenter {
        void login(String username, String password);
    }
}
