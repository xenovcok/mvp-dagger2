package com.bmt.zicreative.maidas.github;

import android.widget.TextView;
import android.widget.Toast;

import com.bmt.zicreative.maidas.R;
import com.bmt.zicreative.maidas.base.BaseActivity;
import com.bmt.zicreative.maidas.base.BasePresenter;
import com.bmt.zicreative.maidas.models.Github;

import javax.inject.Inject;

import butterknife.BindView;
import dagger.android.AndroidInjection;

/**
 * Created By Herwin DJ on 7/24/2018
 **/

public class GithubActivity extends BaseActivity implements GithubContract.View {

    private Github github;

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
    public int getLayout() {
        return R.layout.github_activity;
    }

    @Override
    public void setup() {
        AndroidInjection.inject(this);
        initData();
    }

    private void initData() {
        tvId.setText(this.github.getId());
        tvLogin.setText(this.github.getLogin());
        tvName.setText(this.github.getName());
        tvEmail.setText(this.github.getEmail());
    }

    @Override
    public BasePresenter attachPresenter() {
        return githubPresenter;
    }

    @Override
    public void onGetDataSuccess(Github github) {
        this.github = github;
    }

    @Override
    public void onGetDataFailed(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
