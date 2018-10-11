package com.bmt.zicreative.maidas.booking.detail;

import android.util.Log;

import com.bmt.zicreative.maidas.api.ApiResponse;
import com.bmt.zicreative.maidas.base.BasePresenter;
import com.bmt.zicreative.maidas.booking.ShopService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;

import javax.inject.Inject;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.HttpException;
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
        view.onSuccess();
    }

    private void handleError(Throwable error) {
        Log.d("DEBUG", "handleError: "+error.getMessage());
        if (error instanceof HttpException) {

            Gson gson = new GsonBuilder().create();

            try {

                String errorBody = ((HttpException) error).response().errorBody().string();
                ApiResponse response = gson.fromJson(errorBody,ApiResponse.class);
                Log.d("ERROR", "handleError: "+response.getMessage());

            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {

        }
    }
}
