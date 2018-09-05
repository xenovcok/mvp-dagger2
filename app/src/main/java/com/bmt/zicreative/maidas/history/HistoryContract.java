package com.bmt.zicreative.maidas.history;

import com.bmt.zicreative.maidas.models.BookingOrder;

import java.util.List;

/**
 * Created By Herwin DJ on 9/5/2018
 **/

public interface HistoryContract {
    interface View {
        void onSuccess(String message);
        void onFailed(String message);
        void onGetDataSuccess(List<BookingOrder> data);
    }

    interface Presenter {
        void getAllOrder(String userId);
    }
}
