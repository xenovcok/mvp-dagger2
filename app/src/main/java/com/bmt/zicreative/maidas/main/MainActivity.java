package com.bmt.zicreative.maidas.main;

import android.support.v7.widget.Toolbar;

import com.bmt.zicreative.maidas.R;
import com.bmt.zicreative.maidas.base.BaseActivity;
import com.bmt.zicreative.maidas.base.BasePresenter;

import butterknife.BindView;

public class MainActivity extends BaseActivity {

    @Override
    protected void bindData() {

    }

    @Override
    public int getLayout() {
        return R.layout.main_activity;
    }

    @Override
    public void setup() {
        showMenuIconToolbar();
        setTitleToolbar("Pullman Barbershop");

    }

    @Override
    public BasePresenter attachPresenter() {
        return null;
    }

}
