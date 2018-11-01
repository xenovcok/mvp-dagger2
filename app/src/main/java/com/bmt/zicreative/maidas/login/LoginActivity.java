package com.bmt.zicreative.maidas.login;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.bmt.zicreative.maidas.PullmanApplication;
import com.bmt.zicreative.maidas.R;
import com.bmt.zicreative.maidas.Utils.AuthenticationUtil;
import com.bmt.zicreative.maidas.base.BaseActivity;
import com.bmt.zicreative.maidas.base.BasePresenter;
import com.bmt.zicreative.maidas.main.MainActivity;
import com.bmt.zicreative.maidas.register.RegisterActivity;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;
import dagger.android.AndroidInjection;

/**
 * Created By Herwin DJ on 9/7/2018
 **/

public class LoginActivity extends BaseActivity implements LoginContract.View {

    private final String TAG = "LoginActivityDebug";

    String user;
    String pass;

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
            Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
            startActivity(intent);
            finish();
            //Toast.makeText(this,"Ke Activity Daftar", Toast.LENGTH_LONG).show();
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
        }else if (checkPreferences()){
            Log.d(TAG, "setup: "+String.valueOf(checkPreferences()));
            loginPresenter.login(user, pass);
        }
        bindData();
    }

    @Override
    public BasePresenter attachPresenter() {
        return loginPresenter;
    }

    @Override
    public void onLoginFailed(String message) {
        Toast.makeText(this,"Login Gagal",Toast.LENGTH_LONG).show();
        btnLogin.setVisibility(View.VISIBLE);
    }

    @Override
    public void onLoginSuccess() {
        startActivity(new Intent(LoginActivity.this, MainActivity.class));
        finish();
    }

    private boolean checkPreferences() {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(PullmanApplication.getInstace());
        user = sharedPreferences.getString("username",null);
        pass = sharedPreferences.getString("password", null);
        if ( user != null && pass != null) {
            return true;
        }else{
            return false;
        }
    }
}
