package com.bmt.zicreative.maidas.booking.barberman;

import com.bmt.zicreative.maidas.models.Barber;

import java.util.List;

/**
 * Created By Herwin DJ on 8/1/2018
 **/

public interface BarberContract {
    interface View {
        void onGetDataSuccess(List<Barber> barber);
        void onGetDataError(String message);
    }

    interface Presenter {
        void getData();
    }
}
