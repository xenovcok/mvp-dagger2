package com.bmt.zicreative.maidas.history;

import dagger.Binds;
import dagger.Module;

/**
 * Created By Herwin DJ on 9/5/2018
 **/

@Module
public interface HistoryModule {

    @Binds
    HistoryContract.View provideHistoryView(HistoryActivity historyActivity);

    @Binds
    HistoryContract.Presenter provideHistoryPresenter(HistoryPresenter historyPresenter);

}
