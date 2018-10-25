package com.bmt.zicreative.maidas.Utils;

import android.util.Base64;

import com.bmt.zicreative.maidas.models.AuthTokenPayload;
import com.google.gson.Gson;

/**
 * Created By Herwin DJ on 10/24/2018
 **/

public class TokenUtil {
    public static AuthTokenPayload toJsonObject(String token) {
        String[] part = token.split("\\.");
        Gson gson = new Gson();
        String jsonob = new String(Base64.decode(part[1].getBytes(),0));
        //Log.d("DEBUG", "data : "+jsonob);
        AuthTokenPayload authTokenPayload = gson.fromJson(jsonob, AuthTokenPayload.class);
        return authTokenPayload;
    }
}
