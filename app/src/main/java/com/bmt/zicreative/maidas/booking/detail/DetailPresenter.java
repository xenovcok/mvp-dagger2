package com.bmt.zicreative.maidas.booking.detail;

import android.util.Log;

import com.bmt.zicreative.maidas.api.ApiResponse;
import com.bmt.zicreative.maidas.base.BasePresenter;
import com.bmt.zicreative.maidas.booking.ShopService;

import javax.inject.Inject;

import retrofit2.Retrofit;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created By Herwin DJ on 8/31/2018
 **/

public class DetailPresenter extends BasePresenter implements DetailContract.Presenter {
    private final ShopService shopService;
    private final DetailContract.View view;

    @Inject
    public DetailPresenter(ShopService shopService, DetailContract.View view) {
        this.shopService = shopService;
        this.view = view;
    }

    @Override
    protected void onViewDestroy() {

    }

    @Override
    public void sendData(OrderModel orderModel) {
        shopService.addNewOrder(orderModel)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::handleResponse, this::handleError);
    }

    private void handleResponse(ApiResponse apiResponse) {
        Log.d("DEBUG", "Response: "+apiResponse.getMessage());
    }

    private void handleError(Throwable throwable) {
        Log.d("DEBUG", "handleError: "+throwable.getMessage());
    }
}
