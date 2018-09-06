package com.bmt.zicreative.maidas.service;

import com.bmt.zicreative.maidas.base.BasePresenter;
import com.bmt.zicreative.maidas.booking.ShopService;
import com.bmt.zicreative.maidas.booking.barberman.BarberContract;
import com.bmt.zicreative.maidas.models.Product;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created By Herwin DJ on 9/6/2018
 **/

public class BarberServicePresenter extends BasePresenter implements BarberServiceContract.Presenter {

    private final ShopService shopService;
    private final BarberServiceContract.View view;
    private List<Product> productList;

    @Inject
    public BarberServicePresenter(ShopService shopService, BarberServiceContract.View view) {
        this.shopService = shopService;
        this.view = view;
        this.productList = new ArrayList<>();
    }

    @Override
    protected void onViewDestroy() {

    }

    @Override
    public void findAllProduct() {
        shopService.getAllProducts()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<Product>>() {
                    @Override
                    public void onCompleted() {
                        view.onSuccess("Data Loaded");
                        view.onGetDataSuccess(productList);
                    }

                    @Override
                    public void onError(Throwable e) {
                        view.onFailed(e.getMessage());
                    }

                    @Override
                    public void onNext(List<Product> products) {
                        productList = products;
                    }
                });
    }
}
