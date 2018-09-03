package com.bmt.zicreative.maidas.booking.detail;

/**
 * Created By Herwin DJ on 8/31/2018
 **/

public interface DetailContract {
    interface View {

    }

    interface Presenter {
        void sendData(OrderModel orderModel);

    }
}
