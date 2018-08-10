package com.bmt.zicreative.maidas.booking.service;

import com.bmt.zicreative.maidas.base.BasePresenter;
import com.bmt.zicreative.maidas.booking.ShopService;
import com.bmt.zicreative.maidas.models.Product;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created By Herwin DJ on 8/9/2018
 **/

public class ServicePresenter extends BasePresenter implements ServiceContract.Presenter {

    private final ShopService shopService;
    private final ServiceContract.View view;

    List<Product> productList;

    @Inject
    public ServicePresenter(ShopService shopService, ServiceContract.View view) {
        this.shopService = shopService;
        this.view = view;
        productList = new ArrayList<>();

    }

    @Override
    protected void onViewDestroy() {

    }

    @Override
    public void findAllProducts() {
        shopService.getAllProducts()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<Product>>() {
                    @Override
                    public void onCompleted() {
                        view.onGetDataSuccess(productList);
                    }

                    @Override
                    public void onError(Throwable e) {
                        view.onGetDataFailed(e.toString());
                    }

                    @Override
                    public void onNext(List<Product> products) {
                        productList = products;
                    }
                });
    }
}
