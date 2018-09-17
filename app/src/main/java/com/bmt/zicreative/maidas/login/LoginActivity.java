package com.bmt.zicreative.maidas.login;

import android.app.Activity;
import android.content.Intent;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.bmt.zicreative.maidas.R;
import com.bmt.zicreative.maidas.base.BaseActivity;
import com.bmt.zicreative.maidas.base.BasePresenter;

import javax.inject.Inject;

import butterknife.BindView;

/**
 * Created By Herwin DJ on 9/7/2018
 **/

public class LoginActivity extends BaseActivity implements LoginContract.View {

    @Inject
    LoginPresenter loginPresenter;

    @BindView(R.id.email_sign_in_button)
    Button btnLogin;

    @BindView(R.id.email)
    AutoCompleteTextView etEmail;

    @BindView(R.id.password)
    EditText etPassword;

    @BindView(R.id.txtDaftar)
    TextView txtDaftar;

    @Override
    protected void bindData() {
        btnLogin.setOnClickListener(view -> {
            loginPresenter.login(String.valueOf(etEmail.getText()), String.valueOf(etPassword.getText()));
        });
        txtDaftar.setOnClickListener(view -> {
            Toast.makeText(this,"Ke Activity Daftar", Toast.LENGTH_LONG).show();
        });
    }

    @Override
    public int getLayout() {
        return R.layout.activity_login;
    }

    @Override
    public void setup() {
        bindData();
    }

    @Override
    public BasePresenter attachPresenter() {
        return loginPresenter;
    }
}
