package com.bmt.zicreative.maidas.booking.detail;

import dagger.Binds;
import dagger.Module;

/**
 * Created By Herwin DJ on 8/31/2018
 **/

@Module
public interface DetailModule {

    @Binds
    DetailContract.View provideDetailView(DetailActivity detailActivity);

    @Binds
    DetailContract.Presenter provideDetailPresenter(DetailPresenter detailPresenter);
}
