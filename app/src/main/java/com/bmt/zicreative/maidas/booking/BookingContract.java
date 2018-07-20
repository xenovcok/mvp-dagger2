package com.bmt.zicreative.maidas.booking;

import java.util.List;

/**
 * Created By Herwin DJ on 7/20/2018
 **/
public interface BookingContract {
    interface View {
        void onLoadData(List<BarbershopModel> barbershopModel);
        void onLoadFailed(String message);
        void onLoadSuccess(String message);
    }

    interface Presenter {
        void getData();
    }
}
