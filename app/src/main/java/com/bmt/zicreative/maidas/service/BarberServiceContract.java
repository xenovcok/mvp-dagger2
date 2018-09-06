package com.bmt.zicreative.maidas.service;

import com.bmt.zicreative.maidas.models.Product;

import java.util.List;

/**
 * Created By Herwin DJ on 9/6/2018
 **/

public interface BarberServiceContract {
    interface View {
        void onSuccess(String message);
        void onFailed(String message);
        void onGetDataSuccess(List<Product> product);
    }

    interface Presenter {
        void findAllProduct();
    }
}
