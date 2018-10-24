package com.bmt.zicreative.maidas.inbox;

/**
 * Created By Herwin DJ on 10/18/2018
 **/

public interface InboxContract {
    interface View {
        void onDataSuccess();
        void onDataFailure(String message);
    }

    interface Presenter {
        void getInbox();
    }
}
