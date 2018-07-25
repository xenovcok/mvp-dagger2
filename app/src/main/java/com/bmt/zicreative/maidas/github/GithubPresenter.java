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

    private CompositeSubscription subscription;

    private Github dataList;

    @Inject
    public GithubPresenter(GithubService githubService, GithubContract.View view) {
        this.githubService = githubService;
        this.view = view;
        this.subscription = new CompositeSubscription();
        this.dataList = new Github();
    }

    @Override
    protected void onViewDestroy() {

    }

    @Override
    public void findAllData() {
        Log.d("onGetData : ", "executing");
        subscription.add(githubService.getGithubData()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<Github>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(Github github) {

                    }
                })
        );
    }
}
