package com.bmt.zicreative.maidas.register;

import com.bmt.zicreative.maidas.models.User;

/**
 * Created By Herwin DJ on 10/23/2018
 **/

public interface RegisterContract {
    interface View {
        void onSuccess(String message);
        void onFailure(String message);
    }
    interface Presenter {
        void addUser(User user);
    }
}
