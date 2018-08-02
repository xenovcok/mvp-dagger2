package com.bmt.zicreative.maidas.booking.avaliability;

import android.widget.Toast;

import com.bmt.zicreative.maidas.R;
import com.bmt.zicreative.maidas.base.BaseActivity;
import com.bmt.zicreative.maidas.base.BasePresenter;
import com.bmt.zicreative.maidas.models.BookingOrder;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import dagger.android.AndroidInjection;

/**
 * Created By Herwin DJ on 8/1/2018
 **/

public class AvailabilityActivity extends BaseActivity implements AvailabilityContract.View {

    List<BookingOrder> datalist;
    String years;
    String month;

    @Inject
    AvailabilityPresenter availabilityPresenter;

    @Override
    protected void bindData() {

    }

    @Override
    public int getLayout() {
        return R.layout.availability_activity;
    }

    @Override
    public void setup() {
        AndroidInjection.inject(this);
        showBackIconToolbar(true);
        setTitleToolbar("Available Date");
        initData();

    }

    @Override
    public BasePresenter attachPresenter() {
        return availabilityPresenter;
    }

    @Override
    public void onGetDataSuccess(List<BookingOrder> orderData) {
        this.datalist.addAll(orderData);
    }

    @Override
    public void onGetDataFailed(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

    private void initData() {
        this.datalist = new ArrayList<>();

        Date tglNow = new Date();

        years = String.valueOf(tglNow.getYear());
        month = String.valueOf(tglNow.getMonth());

        availabilityPresenter.getOrderDataByDate(years, month);
    }
}
