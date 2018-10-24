package com.bmt.zicreative.maidas.profile;

/**
 * Created By Herwin DJ on 10/11/2018
 **/

public interface ProfileContract {
    interface View {
        void onLogout();
    }

    interface Presenter {
        void logout();
    }
}
