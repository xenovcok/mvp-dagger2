package com.bmt.zicreative.maidas.login;

import com.bmt.zicreative.maidas.R;
import com.bmt.zicreative.maidas.base.BaseActivity;
import com.bmt.zicreative.maidas.base.BasePresenter;

import javax.inject.Inject;

/**
 * Created By Herwin DJ on 9/7/2018
 **/

public class LoginActivity extends BaseActivity implements LoginContract.View {

    @Inject
    LoginPresenter loginPresenter;

    @Override
    protected void bindData() {

    }

    @Override
    public int getLayout() {
        return R.layout.activity_login;
    }

    @Override
    public void setup() {

    }

    @Override
    public BasePresenter attachPresenter() {
        return null;
    }
}
