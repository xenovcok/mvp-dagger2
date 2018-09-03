package com.bmt.zicreative.maidas.booking.detail;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.widget.TextView;

import com.bmt.zicreative.maidas.R;
import com.bmt.zicreative.maidas.base.BaseActivity;
import com.bmt.zicreative.maidas.base.BasePresenter;

import java.util.Date;

import javax.inject.Inject;

import butterknife.BindView;
import dagger.android.AndroidInjection;

/**
 * Created By Herwin DJ on 8/10/2018
 **/

public class DetailActivity extends BaseActivity implements DetailContract.View {

    OrderModel data;

    @Inject
    DetailPresenter detailPresenter;

    @BindView(R.id.btn_detail_proses)
    TextView btnProses;

    @Override
    protected void bindData() {

    }

    @Override
    public int getLayout() {
        return R.layout.activity_booking_detail;
    }

    @Override
    public void setup() {
        AndroidInjection.inject(this);
        showBackIconToolbar(true);
        setTitleToolbar("Confirm Booking");
        btnProses.setOnClickListener(view -> {
            data = new OrderModel();
            data.setTotal("50000");
            detailPresenter.sendData(data);
        });
    }

    private void showConfirmation(OrderModel data) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder
                .setMessage("Pesan Sekarang ?")
                .setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id){
                        detailPresenter.sendData(data);
                        //Log.d("DEBUG", "onClick: "+String.valueOf(data.getTotal()));
                    }
                })
                .setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id){
                        dialog.cancel();
                    }
                }).show();
    }

    @Override
    public BasePresenter attachPresenter() {
        return detailPresenter;
    }
}
