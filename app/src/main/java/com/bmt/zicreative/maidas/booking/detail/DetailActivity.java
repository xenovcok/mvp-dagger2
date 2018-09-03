package com.bmt.zicreative.maidas.booking.detail;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.widget.TextView;

import com.bmt.zicreative.maidas.R;
import com.bmt.zicreative.maidas.base.BaseActivity;
import com.bmt.zicreative.maidas.base.BasePresenter;

import java.util.Date;
import java.util.Random;

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
            Intent a = getIntent();
            data = new OrderModel();
            data.setTotal((a.getStringExtra("total")));
            data.setBarbermanId(a.getStringExtra("barberId"));
            data.setHeldDate(a.getStringExtra("bookingDate"));
            data.setProcessedAt("");
            data.setBookId("BOOK-"+genBookId());
            data.setStatus("Not Done");
            data.setUserId("andi@gmail.com");
            data.setProductId(a.getStringArrayListExtra("serviceItem"));
            data.setCreatedAt(String.valueOf(new Date()));

            Log.d("DEBUG", "Total: "+a.getIntExtra("total", 0));
            Log.d("DEBUG", "BarbermanId: "+a.getStringExtra("barberId"));
            Log.d("DEBUG", "HeldDate: "+a.getStringExtra("bookingDate"));
            Log.d("DEBUG", "Product Size: "+a.getStringArrayListExtra("serviceItem"));
            //detailPresenter.sendData(data);
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

    private String genBookId() {
        Random rand = new Random();
        int num = rand.nextInt(9000000) + 1000000;
        return String.valueOf(num);
    }
}
