package com.bmt.zicreative.maidas.github;

import com.bmt.zicreative.maidas.base.BasePresenter;
import com.bmt.zicreative.maidas.models.Github;

import javax.inject.Inject;

import retrofit2.Retrofit;
import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created By Herwin DJ on 7/24/2018
 **/

public class GithubPresenter extends BasePresenter implements GithubContract.Presenter {
    GithubService githubService;
    GithubContract.View view;

    @Inject
    public GithubPresenter(GithubService githubService, GithubContract.View view) {
        this.githubService = githubService;
        this.view = view;
    }

    @Override
    protected void onViewDestroy() {

    }

    @Override
    public void onGetData() {
        githubService.getGithubData()
                .subscribeOn(AndroidSchedulers.mainThread())
                .observeOn(Schedulers.io())
                .subscribe(new Observer<Github>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        view.onGetDataFailed(e.toString());
                    }

                    @Override
                    public void onNext(Github github) {
                        view.onGetDataSuccess(github);
                    }
                });
    }
}
