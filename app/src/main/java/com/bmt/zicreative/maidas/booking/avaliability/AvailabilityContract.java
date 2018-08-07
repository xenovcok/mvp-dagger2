package com.bmt.zicreative.maidas.booking.avaliability;

import com.bmt.zicreative.maidas.models.BookingOrder;

import java.util.List;

/**
 * Created By Herwin DJ on 8/2/2018
 **/

public interface AvailabilityContract {
    interface View {
        void onGetDataSuccess(List<BookingOrder> orderData);
        void onGetDataFailed(String message);
    }

    interface Presenter {
        void getOrderDataByDate(String years, String month);
        void checkAvailableDate(String year, String month, String day);
    }
}
