package com.bmt.zicreative.maidas.github;

import android.util.Log;

import com.bmt.zicreative.maidas.base.BasePresenter;
import com.bmt.zicreative.maidas.models.Github;

import java.util.ArrayList;

import javax.inject.Inject;

import retrofit2.Retrofit;
import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

/**
 * Created By Herwin DJ on 7/24/2018
 **/

public class GithubPresenter extends BasePresenter implements GithubContract.Presenter {
    GithubService githubService;
    GithubContract.View view;

    private Github data;

    @Inject
    public GithubPresenter(GithubService githubService, GithubContract.View view) {
        this.githubService = githubService;
        this.view = view;
        this.data = new Github();
    }

    @Override
    protected void onViewDestroy() {

    }

    @Override
    public void findAllData() {
        Log.d("onGetData : ", "executing");
        githubService.getGithubData()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Github>() {
                    @Override
                    public void onCompleted() {
                        Log.d("onComplete : ", "OK");
                        view.onGetDataSuccess(data);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d("onError : ", e.getMessage());
                    }

                    @Override
                    public void onNext(Github github) {
                        data = github;
                    }
                });
    }
}
