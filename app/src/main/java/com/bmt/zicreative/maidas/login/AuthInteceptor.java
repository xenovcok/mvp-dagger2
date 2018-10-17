package com.bmt.zicreative.maidas.login;

import android.util.Log;

import com.bmt.zicreative.maidas.Utils.AuthenticationUtil;

import java.io.IOException;
import java.util.Base64;

import javax.inject.Inject;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created By Herwin DJ on 9/17/2018
 **/

public class AuthInteceptor implements Interceptor {
    private static String CLIENT_ID = "ab3281e3e92be1299be23087b6c8c429";
    private static String CLIENT_SECRET = "a2dc22a818f8cd4003b61074480edbfd86d9246bc6958cca4ed9ed0872f54762";
    private String loginAuthHeader;
    private AuthenticationUtil authenticationUtil;

    @Inject
    public AuthInteceptor(AuthenticationUtil authenticationUtil) {
        try {
            this.loginAuthHeader = "Basic " + android.util.Base64.encodeToString((CLIENT_ID + ":" + CLIENT_SECRET).getBytes(), android.util.Base64.NO_WRAP);
            this.authenticationUtil = authenticationUtil;
        }catch (Exception e) {
            Log.e("error : ", e.getMessage());
        }
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request original = chain.request();
        if (original.url().encodedPath().equals("/api/oauth/token")) {
            return chain.proceed(original.newBuilder()
                    .header("Content-Type", "application/x-www-form-urlencoded")
                    .header("Authorization", loginAuthHeader)
                    .build());
        }  else if (authenticationUtil.getCurrentAuthenticate() != null) {
            return chain.proceed(original.newBuilder()
                    .header("Authorization", "Bearer " + authenticationUtil.getCurrentAuthenticate().getAccessToken())
                    .build());
        } else {
            return chain.proceed(original);
        }
    }
}
