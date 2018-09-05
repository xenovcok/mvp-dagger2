package com.bmt.zicreative.maidas.history;

import android.content.Context;

import com.bmt.zicreative.maidas.base.BasePresenter;
import com.bmt.zicreative.maidas.booking.ShopService;
import com.bmt.zicreative.maidas.models.BookingOrder;

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
    private final HistoryContract.View view;
    private List<BookingOrder> dataList;

    @Inject
    public HistoryPresenter(ShopService shopService, HistoryContract.View view) {
        this.shopService = shopService;
        this.view = view;
        this.dataList = new ArrayList<>();
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
}
