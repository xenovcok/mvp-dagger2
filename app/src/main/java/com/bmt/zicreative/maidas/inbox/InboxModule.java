package com.bmt.zicreative.maidas.inbox;

import dagger.Binds;
import dagger.Module;

/**
 * Created By Herwin DJ on 10/18/2018
 **/

@Module
public interface InboxModule {

    @Binds
    InboxContract.View provideInboxView(InboxActivity inboxActivity);

    @Binds
    InboxContract.Presenter provideInboxPresenter(InboxPresenter inboxPresenter);
}
