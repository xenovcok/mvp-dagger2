package com.bmt.zicreative.maidas.main;

import com.bmt.zicreative.maidas.R;
import com.bmt.zicreative.maidas.base.BaseActivity;
import com.bmt.zicreative.maidas.base.BasePresenter;

public class MainActivity extends BaseActivity {

    @Override
    public int getLayout() {
        return R.layout.main_activity;
    }

    @Override
    public void setup() {

    }

    @Override
    public BasePresenter attachPresenter() {
        return null;
    }
}
