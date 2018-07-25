package com.bmt.zicreative.maidas.booking;

import android.annotation.SuppressLint;
import android.util.Log;
import android.widget.Toast;

import com.bmt.zicreative.maidas.base.BasePresenter;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created By Herwin DJ on 7/20/2018
 **/

public class BarbershopPresenter extends BasePresenter implements BookingContract.Presenter {
    private final ShopService shopService;
    private final BookingContract.View view;
    private List<BarbershopModel> data;

    @Inject
    public BarbershopPresenter(ShopService shopService, BookingContract.View view) {
        this.shopService = shopService;
        this.view = view;
        this.data = new ArrayList<>();
    }

    @Override
    protected void onViewDestroy() {

    }

    @SuppressLint("RxLeakedSubscription")
    @Override
    public void getData() {
        Log.d("getData : ", "Executing ...");
        shopService.getShopList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<BarbershopModel>>() {
                    @Override
                    public void onCompleted() {
                        Log.d("OnCompleted", "OK");
                        view.onLoadData(data);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d("onError : ", e.getMessage());
                        view.onLoadFailed("Network Error");
                    }

                    @Override
                    public void onNext(List<BarbershopModel> barbershopModel) {
                        Log.d("onNext", "ok");
                        data = barbershopModel;
                    }
                });
    }
}
