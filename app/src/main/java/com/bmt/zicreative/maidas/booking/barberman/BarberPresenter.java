package com.bmt.zicreative.maidas.booking.barberman;

import com.bmt.zicreative.maidas.base.BasePresenter;
import com.bmt.zicreative.maidas.booking.ShopService;
import com.bmt.zicreative.maidas.models.Barber;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created By Herwin DJ on 8/1/2018
 **/

public class BarberPresenter extends BasePresenter implements BarberContract.Presenter {

    private final ShopService shopService;
    private final BarberContract.View view;
    List<Barber> barberDataList;

    @Inject
    public BarberPresenter(ShopService shopService, BarberContract.View view) {
        this.shopService = shopService;
        this.view = view;
        this.barberDataList = new ArrayList<>();
    }

    @Override
    public void getData() {
        shopService.getUserByRole("EMP")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<Barber>>() {
                    @Override
                    public void onCompleted() {
                        view.onGetDataSuccess(barberDataList);
                    }

                    @Override
                    public void onError(Throwable e) {
                        view.onGetDataError(e.getMessage());
                    }

                    @Override
                    public void onNext(List<Barber> barbers) {
                        barberDataList = barbers;
                    }
                });
    }

    @Override
    protected void onViewDestroy() {

    }
}
