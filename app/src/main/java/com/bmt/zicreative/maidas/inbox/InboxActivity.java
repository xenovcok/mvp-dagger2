package com.bmt.zicreative.maidas.inbox;

import com.bmt.zicreative.maidas.R;
import com.bmt.zicreative.maidas.base.BaseActivity;
import com.bmt.zicreative.maidas.base.BasePresenter;

/**
 * Created By Herwin DJ on 10/18/2018
 **/

public class InboxActivity extends BaseActivity implements InboxContract.View {
    @Override
    protected void bindData() {

    }

    @Override
    public int getLayout() {
        return R.layout.activity_inbox;
    }

    @Override
    public void setup() {

    }

    @Override
    public BasePresenter attachPresenter() {
        return null;
    }

    @Override
    public void onDataSuccess() {

    }

    @Override
    public void onDataFailure(String message) {

    }
}
