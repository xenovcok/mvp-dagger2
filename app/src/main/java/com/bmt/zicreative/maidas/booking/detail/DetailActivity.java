package com.bmt.zicreative.maidas.booking.detail;

import com.bmt.zicreative.maidas.R;
import com.bmt.zicreative.maidas.base.BaseActivity;
import com.bmt.zicreative.maidas.base.BasePresenter;

/**
 * Created By Herwin DJ on 8/10/2018
 **/

public class DetailActivity extends BaseActivity {
    @Override
    protected void bindData() {

    }

    @Override
    public int getLayout() {
        return R.layout.activity_booking_detail;
    }

    @Override
    public void setup() {
        showBackIconToolbar(true);
        setTitleToolbar("Confirm Booking");
    }

    @Override
    public BasePresenter attachPresenter() {
        return null;
    }
}
