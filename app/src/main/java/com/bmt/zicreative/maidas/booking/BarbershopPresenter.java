package com.bmt.zicreative.maidas.booking;

import android.widget.Toast;

import com.bmt.zicreative.maidas.base.BasePresenter;

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

    @Inject
    public BarbershopPresenter(ShopService shopService, BookingContract.View view) {
        this.shopService = shopService;
        this.view = view;
    }

    @Override
    protected void onViewDestroy() {

    }

    @Override
    public void getData() {
        shopService.getShopList()
                .subscribeOn(AndroidSchedulers.mainThread())
                .observeOn(Schedulers.io())
                .subscribe(new Observer<List<BarbershopModel>>() {
                    @Override
                    public void onCompleted() {
                        view.onLoadSuccess("Data Loaded");
                    }

                    @Override
                    public void onError(Throwable e) {
                        view.onLoadFailed("Network Error");
                    }

                    @Override
                    public void onNext(List<BarbershopModel> barbershopModel) {
                        view.onLoadData(barbershopModel);
                    }
                });
    }
}
