package com.bmt.zicreative.maidas.booking.avaliability;

import com.bmt.zicreative.maidas.base.BasePresenter;
import com.bmt.zicreative.maidas.booking.BarbershopModel;
import com.bmt.zicreative.maidas.booking.ShopService;
import com.bmt.zicreative.maidas.models.BookingOrder;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created By Herwin DJ on 8/2/2018
 **/

public class AvailabilityPresenter extends BasePresenter implements AvailabilityContract.Presenter {

    private ShopService shopService;
    private AvailabilityContract.View view;
    private List<BookingOrder> orderData;

    @Inject
    public AvailabilityPresenter(ShopService shopService, AvailabilityContract.View view) {
        this.shopService = shopService;
        this.view = view;
        this.orderData = new ArrayList<>();
    }

    @Override
    protected void onViewDestroy() {

    }

    @Override
    public void getOrderDataByDate(String years, String month) {
        shopService.getOrderByDate(years, month)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<BookingOrder>>() {
                    @Override
                    public void onCompleted() {
                        view.onGetDataSuccess(orderData);
                    }

                    @Override
                    public void onError(Throwable e) {
                        view.onGetDataFailed(e.getMessage());
                    }

                    @Override
                    public void onNext(List<BookingOrder> bookingOrders) {
                        orderData = bookingOrders;
                    }
                });
    }

    @Override
    public void checkAvailableDate(String year, String month, String day) {
        shopService.getOrderByDay(year, month, day)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<BookingOrder>>() {
                    @Override
                    public void onCompleted() {
                        view.onGetDataSuccess(orderData);
                    }

                    @Override
                    public void onError(Throwable e) {
                        view.onGetDataFailed(e.getMessage());
                    }

                    @Override
                    public void onNext(List<BookingOrder> bookingOrders) {
                        orderData = bookingOrders;
                    }
                });
    }
}
