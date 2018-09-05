package com.bmt.zicreative.maidas.booking.detail;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Adapter;
import android.widget.TextView;

import com.bmt.zicreative.maidas.R;
import com.bmt.zicreative.maidas.base.BaseActivity;
import com.bmt.zicreative.maidas.base.BasePresenter;
import com.bmt.zicreative.maidas.booking.service.ServiceActivity;
import com.bmt.zicreative.maidas.models.Product;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.TimeZone;

import javax.inject.Inject;

import butterknife.BindView;
import dagger.android.AndroidInjection;

/**
 * Created By Herwin DJ on 8/10/2018
 **/

public class DetailActivity extends BaseActivity implements DetailContract.View {

    OrderModel data;
    Intent a;
    List<Product> productList;
    DetailListItemAdapter adapter;

    int total;

    @Inject
    DetailPresenter detailPresenter;

    @BindView(R.id.detail_item_list)
    RecyclerView rvDetailItemList;

    @BindView(R.id.tvDetailSubTotal)
    TextView tvSubTotal;

    @BindView(R.id.tvDetailTotal)
    TextView tvTotalBayar;

    @BindView(R.id.tvPajak)
    TextView tvPajak;

    @BindView(R.id.btn_detail_proses)
    TextView btnProses;

    @Override
    protected void bindData() {

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if(id == android.R.id.home) {
            startActivity(new Intent(DetailActivity.this, ServiceActivity.class));
        }
        return super.onOptionsItemSelected(item);
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
        initRecycleViewManager();
        initData();
        btnProses.setOnClickListener(view -> {
            data = new OrderModel();
            data.setTotal(String.valueOf(total+(total*0.1)));
            data.setUserId("andi@gmail.com");
            data.setCreatedAt(getNowDate());
            data.setBarbermanId(a.getStringExtra("barberId"));
            data.setHeldDate(a.getStringExtra("bookingDate"));
            //data.setProcessedAt("");
            data.setBookId("BOOK-"+genBookId());
            //data.setStatus("Not Done");

            data.setProductId(a.getStringArrayListExtra("serviceItem"));


            Log.d("DEBUG", "Total: "+a.getIntExtra("total", 0));
            Log.d("DEBUG", "BarbermanId: "+a.getStringExtra("barberId"));
            Log.d("DEBUG", "HeldDate: "+a.getStringExtra("bookingDate"));
            Log.d("DEBUG", "Product Size: "+a.getStringArrayListExtra("serviceItem"));
            Log.d("DEBUG", "Obj : "+data.getBookId());
            detailPresenter.sendData(data);
        });
    }

    private void initData() {
        a = getIntent();
        productList = (List<Product>) a.getSerializableExtra("PRODUCT");
        total = a.getIntExtra("total", 0);

        initView();
    }

    private void initView() {
        adapter = new DetailListItemAdapter(DetailActivity.this, productList);
        rvDetailItemList.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        tvSubTotal.setText(String.valueOf("Rp. "+total));
        tvTotalBayar.setText(String.valueOf("Rp. "+(total+(total/10))));
        tvPajak.setText(String.valueOf("Rp. "+(total/10)));
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

    private void initRecycleViewManager() {
        rvDetailItemList.setLayoutManager(new LinearLayoutManager(this));
    }

    private String genBookId() {
        Random rand = new Random();
        int num = rand.nextInt(9000000) + 1000000;
        return String.valueOf(num);
    }

    private String getNowDate() {
        TimeZone tz = TimeZone.getTimeZone("UTC");
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        df.setTimeZone(tz);
        return df.format(new Date());
    }
}
