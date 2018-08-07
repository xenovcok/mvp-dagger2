package com.bmt.zicreative.maidas.booking.avaliability;

import android.app.DatePickerDialog;
import android.graphics.Color;
import android.support.v7.widget.AppCompatButton;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.bmt.zicreative.maidas.R;
import com.bmt.zicreative.maidas.base.BaseActivity;
import com.bmt.zicreative.maidas.base.BasePresenter;
import com.bmt.zicreative.maidas.models.BookingOrder;
import com.google.gson.internal.bind.util.ISO8601Utils;

import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
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

    String bookYear;
    String bookMonth;
    String bookDay;
    String bookTime;

    Calendar nowDate;
    Calendar bookingDate;
    String saveBookingDate;

    DatePickerDialog datePickerDialog;

    @BindView(R.id.tvAvaiTitle)
    TextView tvAvaiTitle;

    @BindView(R.id.tv_avai_date)
    EditText etDate;

    @BindView(R.id.btn1)
    AppCompatButton btn1;

    @BindView(R.id.btn2)
    AppCompatButton btn2;

    @BindView(R.id.btn3)
    AppCompatButton btn3;

    @BindView(R.id.btn4)
    AppCompatButton btn4;

    @BindView(R.id.btn5)
    AppCompatButton btn5;

    @BindView(R.id.btn6)
    AppCompatButton btn6;

    @BindView(R.id.btn7)
    AppCompatButton btn7;

    @BindView(R.id.btn8)
    AppCompatButton btn8;

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
        initUI();

        etDate.setOnClickListener(view -> {
            onClickPopup();
        });
    }



    private void disableButton(AppCompatButton btn) {
        btn.setEnabled(false);
        btn.setBackgroundResource(R.color.grey);
    }

    private void enableButton(AppCompatButton btn) {
        btn.setEnabled(true);
        btn.setBackgroundResource(R.color.colorPrimary);
    }

    private void initUI() {

        disableButton(findViewById(R.id.btn1));
        disableButton(findViewById(R.id.btn2));
        disableButton(findViewById(R.id.btn3));
        disableButton(findViewById(R.id.btn4));
        disableButton(findViewById(R.id.btn5));
        disableButton(findViewById(R.id.btn6));
        disableButton(findViewById(R.id.btn7));
        disableButton(findViewById(R.id.btn8));

    }

    private void setEnableButton() {
        enableButton(findViewById(R.id.btn1));
        enableButton(findViewById(R.id.btn2));
        enableButton(findViewById(R.id.btn3));
        enableButton(findViewById(R.id.btn4));
        enableButton(findViewById(R.id.btn5));
        enableButton(findViewById(R.id.btn6));
        enableButton(findViewById(R.id.btn7));
        enableButton(findViewById(R.id.btn8));
    }

    private void setUIButton(int tgl) {
        setEnableButton();
        switch (tgl) {
            case 10:
                disableButton(findViewById(R.id.btn1));
                break;
            case 11:
                disableButton(findViewById(R.id.btn2));
                break;
            case 12:
                disableButton(findViewById(R.id.btn3));
                break;
            case 1:
                disableButton(findViewById(R.id.btn4));
                break;
            case 2:
                disableButton(findViewById(R.id.btn5));
                break;
            case 3:
                disableButton(findViewById(R.id.btn6));
                break;
            case 4:
                disableButton(findViewById(R.id.btn7));
                break;
            case 5:
                disableButton(findViewById(R.id.btn8));
                break;
        }
    }

    private void onClickPopup() {
        Calendar calendar = Calendar.getInstance();

        datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth){
                Calendar newDate = Calendar.getInstance();
                newDate.set(year, monthOfYear, dayOfMonth);
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                SimpleDateFormat bookDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
                if(calendar.get(Calendar.DAY_OF_MONTH) > dayOfMonth){
                    Toast.makeText(AvailabilityActivity.this, "Invalid Date", Toast.LENGTH_SHORT).show();
                }else{
                    etDate.setText(sdf.format(newDate.getTime()));
                    saveBookingDate = bookDateFormat.format(newDate.getTime());

                    Log.d("DEBUG", "Saved bookingDate : "+saveBookingDate);

                    Date tempDate = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").parse(saveBookingDate, new ParsePosition(0));
                    Calendar tempCalendar = new GregorianCalendar();
                    tempCalendar.setTime(tempDate);

                    if(tempCalendar.get(Calendar.MONTH) < 10) {
                        bookMonth = "0"+String.valueOf(tempCalendar.get(Calendar.MONTH));
                    }else{
                        bookMonth = String.valueOf(tempCalendar.get(Calendar.MONTH));
                    }

                    if(tempCalendar.get(Calendar.DAY_OF_MONTH) < 10) {
                        bookDay = "0"+String.valueOf(tempCalendar.get(Calendar.DAY_OF_MONTH));
                    }else{
                        bookDay = String.valueOf(tempCalendar.get(Calendar.DAY_OF_MONTH));
                    }

                    bookYear = String.valueOf(tempCalendar.get(Calendar.YEAR));

                    availabilityPresenter.checkAvailableDate(bookYear, "05", "16");

                    Log.d("DEBUG", "Year : "+bookYear+" Month : "+bookMonth+" Day : "+bookDay);
                }

            }
        }, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));
        datePickerDialog.getDatePicker().setMinDate(System.currentTimeMillis() - 1000);
        datePickerDialog.show();
    }

    private void setData() {
        if(datalist.isEmpty()) {
            Log.d("DEBUG", "Data List Empty");
        }else {
            bookingDate = new GregorianCalendar();
            SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
            for (int i = 0; i < datalist.size(); i++) {
                Date d = sd.parse(datalist.get(i).getBookForDate(), new ParsePosition(0));
                bookingDate.setTime(d);
                setUIButton(bookingDate.get(Calendar.HOUR));
                //Log.d("DEBUG", "setData: Tahun "+bookingDate.toString());
                Log.d("DEBUG", "setData: Tahun "+ bookingDate.get(Calendar.YEAR)+" Jam "+bookingDate.get(Calendar.HOUR));
            }
        }
    }

    @Override
    public BasePresenter attachPresenter() {
        return availabilityPresenter;
    }

    @Override
    public void onGetDataSuccess(List<BookingOrder> orderData) {
        //Log.d("DEBUG", "orderData size "+orderData.size());
        this.datalist.addAll(orderData);
        setData();
    }

    @Override
    public void onGetDataFailed(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

    private void initData() {
        this.datalist = new ArrayList<>();

        nowDate = getNowDate();

        years = String.valueOf(nowDate.get(Calendar.YEAR));
        month = String.valueOf(nowDate.get(Calendar.MONTH)+1);

       // Log.d("DEBUG", " Tahun: "+years);
       // Log.d("DEBUG", " Bulan: "+month);
    }

    private Calendar getNowDate() {
        Date now = new Date();
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(now);
        return calendar;
    }

    /*
    private Calendar dateToCalendar (String date) {
        Calendar c = new GregorianCalendar();
        c.setTime(ISO8601formatter(date));
        return c;
    }

    private Date ISO8601formatter(String input) {
        Date parsed = new Date();
        try {
             parsed = ISO8601Utils.parse(input, new ParsePosition(0));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return parsed;
    }
    */

    /*
    private String monthParser(String month) {
        String parsed = "";
        switch (month) {
            case "1" :
                parsed = "01";
                break;
            case "2" :
                parsed = "02";
                break;
            case "3" :
                parsed = "03";
                break;
            case "4" :
                parsed = "04";
                break;
            case "5" :
                parsed = "05";
                break;
            case "6" :
                parsed = "06";
                break;
            case "7" :
                parsed = "07";
                break;
            case "8" :
                parsed = "08";
                break;
            case "9" :
                parsed = "09";
                break;
        }

        return parsed;
    }
    */
}
