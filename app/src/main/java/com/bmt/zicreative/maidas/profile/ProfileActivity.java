package com.bmt.zicreative.maidas.profile;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Base64;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;

import com.auth0.android.jwt.JWT;
import com.bmt.zicreative.maidas.PullmanApplication;
import com.bmt.zicreative.maidas.R;
import com.bmt.zicreative.maidas.Utils.AuthenticationUtil;
import com.bmt.zicreative.maidas.Utils.TokenUtil;
import com.bmt.zicreative.maidas.base.BaseActivity;
import com.bmt.zicreative.maidas.base.BasePresenter;
import com.bmt.zicreative.maidas.login.LoginActivity;
import com.bmt.zicreative.maidas.main.MainActivity;
import com.bmt.zicreative.maidas.models.AuthTokenPayload;
import com.bmt.zicreative.maidas.models.Authenticate;
import com.bmt.zicreative.maidas.models.User;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import dagger.android.AndroidInjection;

/**
 * Created By Herwin DJ on 10/11/2018
 **/

public class ProfileActivity extends BaseActivity implements ProfileContract.View {

    @Inject
    AuthenticationUtil authenticationUtil;

    @Inject
    ProfilePresenter presenter;

    String token;
    JsonObject userData;

    Gson gson = new Gson();

    @BindView(R.id.name)
    TextView tvName;

    @BindView(R.id.email)
    TextView tvEmail;

    @Override
    protected void bindData() {
        Authenticate currentAuthenticate = authenticationUtil.getCurrentAuthenticate();
        token = currentAuthenticate.getAccessToken();
        AuthTokenPayload usr = TokenUtil.toJsonObject(token);
        //Log.d("DEBUG", "bindData: "+userData.get("name"));

        tvName.setText(String.valueOf(usr.getName()));
        tvEmail.setText(String.valueOf(usr.getEmail()));
    }


    @Override
    public int getLayout() {
        return R.layout.alternate_profile_activity;
    }

    @Override
    public void setup() {
        AndroidInjection.inject(this);
        showBackIconToolbar(true);
        ButterKnife.bind(this);
    }

    @Override
    public BasePresenter attachPresenter() {
        return presenter;
    }

    @Override
    public void onLogout() {
        startActivity(new Intent(ProfileActivity.this, LoginActivity.class));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.logout :
                presenter.logout();
                finish();
                break;
            case android.R.id.home :
                startActivity(new Intent(ProfileActivity.this, MainActivity.class));
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}


