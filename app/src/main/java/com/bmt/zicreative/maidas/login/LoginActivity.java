package com.bmt.zicreative.maidas.login;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.bmt.zicreative.maidas.R;
import com.bmt.zicreative.maidas.Utils.AuthenticationUtil;
import com.bmt.zicreative.maidas.base.BaseActivity;
import com.bmt.zicreative.maidas.base.BasePresenter;
import com.bmt.zicreative.maidas.main.MainActivity;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;
import dagger.android.AndroidInjection;

/**
 * Created By Herwin DJ on 9/7/2018
 **/

public class LoginActivity extends BaseActivity implements LoginContract.View {

    @Inject
    LoginPresenter loginPresenter;

    @Inject
    AuthenticationUtil authenticationUtil;

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
        txtDaftar.setOnClickListener(view -> {
            Toast.makeText(this,"Ke Activity Daftar", Toast.LENGTH_LONG).show();
        });
    }

    @OnClick(R.id.email_sign_in_button)
    public void onLoginClicked() {
        btnLogin.setVisibility(View.GONE);

        String username = etEmail.getText().toString();
        String password = etPassword.getText().toString();

        loginPresenter.login(username,password);
    }

    @Override
    public int getLayout() {
        return R.layout.activity_login;
    }

    @Override
    public void setup() {
        AndroidInjection.inject(this);
        if (authenticationUtil.getCurrentAuthenticate() != null) {
            startActivity(new Intent(LoginActivity.this, MainActivity.class));
            finish();
        }
        bindData();
    }

    @Override
    public BasePresenter attachPresenter() {
        return loginPresenter;
    }

    @Override
    public void onLoginFailed(String message) {
        Toast.makeText(this,message,Toast.LENGTH_LONG).show();
    }

    @Override
    public void onLoginSuccess() {
        startActivity(new Intent(LoginActivity.this, MainActivity.class));
        finish();
    }
}
