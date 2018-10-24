package com.bmt.zicreative.maidas.register;

import android.content.Intent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.bmt.zicreative.maidas.R;
import com.bmt.zicreative.maidas.base.BaseActivity;
import com.bmt.zicreative.maidas.base.BasePresenter;
import com.bmt.zicreative.maidas.login.LoginActivity;
import com.bmt.zicreative.maidas.models.User;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import dagger.android.AndroidInjection;

/**
 * Created By Herwin DJ on 10/23/2018
 **/

public class RegisterActivity extends BaseActivity implements RegisterContract.View {

    User user;

    @Inject
    RegisterPresenter presenter;

    @BindView(R.id.txtLogin)
    TextView txtLogin;

    @BindView(R.id.username)
    EditText etUsername;

    @BindView(R.id.email)
    EditText etEmail;

    @BindView(R.id.password)
    EditText etPasswd;

    @BindView(R.id.register_submit)
    Button btnRegSubmit;

    @Override
    protected void bindData() {
        txtLogin.setOnClickListener(view -> {
            Intent i = new Intent(RegisterActivity.this, LoginActivity.class);
            startActivity(i);
            finish();
        });
    }

    @Override
    public int getLayout() {
        return R.layout.register_activity;
    }

    @Override
    public void setup() {
        AndroidInjection.inject(this);
        ButterKnife.bind(this);

        btnRegSubmit.setOnClickListener(view -> {
            user = new User();
            user.setEmail(String.valueOf(etEmail.getText()));
            user.setUserName(String.valueOf(etUsername.getText()));
            user.setPassword(String.valueOf(etPasswd.getText()));
            user.setName(String.valueOf(etUsername.getText()));
            user.setRole("CUST");

            presenter.addUser(user);
        });

    }

    @Override
    public BasePresenter attachPresenter() {
        return presenter;
    }

    @Override
    public void onSuccess(String message) {
        Toast.makeText(this,message, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onFailure(String message) {
        Toast.makeText(this,message, Toast.LENGTH_LONG).show();
    }
}
