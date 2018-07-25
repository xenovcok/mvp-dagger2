package com.bmt.zicreative.maidas.github;

import com.bmt.zicreative.maidas.models.Github;

/**
 * Created By Herwin DJ on 7/24/2018
 **/

public interface GithubContract {
    interface View {
        void onGetDataSuccess(Github github);
        void onGetDataFailed(String message);
    }

    interface Presenter {
        void findAllData();
    }
}
