package com.bmt.zicreative.maidas.github;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;

/**
 * Created By Herwin DJ on 7/24/2018
 **/

@Module
public interface GithubModule {

    @Binds
    GithubContract.Presenter provideGithubPresenter(GithubPresenter githubPresenter);

    @Binds
    GithubContract.View provideGithubView(GithubActivity githubActivity);
}
