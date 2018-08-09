package com.bmt.zicreative.maidas.booking.service;

import com.bmt.zicreative.maidas.models.Product;

import java.util.List;

/**
 * Created By Herwin DJ on 8/9/2018
 **/

public interface ServiceContract {
    interface View {
        void onGetDataSuccess(List<Product> productList);
        void onGetDataFailed(String message);
    }

    interface Presenter {
        void findAllProducts();
    }
}
