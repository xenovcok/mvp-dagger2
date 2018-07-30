package com.bmt.zicreative.maidas.github;

import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.bmt.zicreative.maidas.R;
import com.bmt.zicreative.maidas.base.BaseActivity;
import com.bmt.zicreative.maidas.base.BasePresenter;
import com.bmt.zicreative.maidas.models.Github;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import dagger.android.AndroidInjection;

/**
 * Created By Herwin DJ on 7/24/2018
 **/

public class GithubActivity extends BaseActivity implements GithubContract.View {

    private Github theData;

    @Inject
    GithubPresenter githubPresenter;

    @BindView(R.id.text_id)
    TextView tvId;

    @BindView(R.id.text_login)
    TextView tvLogin;

    @BindView(R.id.text_name)
    TextView tvName;

    @BindView(R.id.text_email)
    TextView tvEmail;

    @Override
    protected void bindData() {
        //Log.d("DEBUGs", "onGetDataSuccess: "+this.theData.getId());
    }

    @Override
    public int getLayout() {
        return R.layout.github_activity;
    }

    @Override
    public void setup() {
        AndroidInjection.inject(this);
        setTitleToolbar("Github Data");
        initData();
    }

    private void initData() {
        githubPresenter.findAllData();
    }

    @Override
    public BasePresenter attachPresenter() {
        return githubPresenter;
    }

    @Override
    public void onGetDataSuccess(Github github) {
        this.theData = github;
        Log.d("DataDebug", String.valueOf(theData.getType()));
        tvId.setText(github.getId().toString());
        tvLogin.setText(github.getLogin());
        tvName.setText(github.getName());
        tvEmail.setText(github.getType());
    }

    @Override
    public void onGetDataFailed(String message) {
        Log.d("Get Data Error", message);
    }
}
