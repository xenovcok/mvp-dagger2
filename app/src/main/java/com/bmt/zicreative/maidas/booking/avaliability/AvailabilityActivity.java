package com.bmt.zicreative.maidas.booking.avaliability;

import com.bmt.zicreative.maidas.R;
import com.bmt.zicreative.maidas.base.BaseActivity;
import com.bmt.zicreative.maidas.base.BasePresenter;

/**
 * Created By Herwin DJ on 8/1/2018
 **/

public class AvailabilityActivity extends BaseActivity {
    @Override
    protected void bindData() {

    }

    @Override
    public int getLayout() {
        return R.layout.availability_activity;
    }

    @Override
    public void setup() {
        showBackIconToolbar(true);
        setTitleToolbar("Available Date");
    }

    @Override
    public BasePresenter attachPresenter() {
        return null;
    }
}
