package com.bmt.zicreative.maidas.history;

import android.content.Context;
import android.util.Log;

import com.bmt.zicreative.maidas.api.UserService;
import com.bmt.zicreative.maidas.base.BasePresenter;
import com.bmt.zicreative.maidas.booking.ShopService;
import com.bmt.zicreative.maidas.models.BookingOrder;
import com.bmt.zicreative.maidas.models.User;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import retrofit2.Retrofit;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created By Herwin DJ on 9/5/2018
 **/

public class HistoryPresenter extends BasePresenter implements HistoryContract.Presenter {

    private final ShopService shopService;
    private final UserService userService;
    private final HistoryContract.View view;
    private List<BookingOrder> dataList;
    private String userName;

    @Inject
    public HistoryPresenter(ShopService shopService, UserService userService, HistoryContract.View view) {
        this.shopService = shopService;
        this.userService = userService;
        this.view = view;
        this.dataList = new ArrayList<>();
        this.userName = "";
    }

    @Override
    protected void onViewDestroy() {

    }

    @Override
    public void getAllOrder(String userId) {
        shopService.getOrderByUserId(userId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<BookingOrder>>() {
                               @Override
                               public void onCompleted() {
                                   view.onSuccess("data loaded");
                                   view.onGetDataSuccess(dataList);
                               }

                               @Override
                               public void onError(Throwable e) {
                                   view.onFailed(e.getMessage());
                               }

                               @Override
                               public void onNext(List<BookingOrder> bookingOrders) {
                                   dataList = bookingOrders;
                               }
                           }

                );
    }

    @Override
    public void getBarberman(String email) {
        userService.getUserByEmail(email)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<User>() {
                    @Override
                    public void onCompleted() {
                        view.onGetNameSuccess(userName);
                    }

                    @Override
                    public void onError(Throwable e) {
                        view.onFailed(e.getMessage());
                    }

                    @Override
                    public void onNext(User user) {
                        userName = user.getName();
                    }
                });
    }
}
