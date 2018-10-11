package com.bmt.zicreative.maidas.Utils;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;

import com.bmt.zicreative.maidas.PullmanApplication;
import com.bmt.zicreative.maidas.models.Authenticate;
import com.google.gson.Gson;

import java.io.IOException;

import javax.inject.Singleton;

/**
 * Created By Herwin DJ on 9/17/2018
 **/

@Singleton
public class AuthenticationUtil {
    private static String AUTHENTICATION = "AUTHENTICATION";

    Gson gson = new Gson();

    public void registerAuthentication(Authenticate authenticate) {
        registerPreference(AUTHENTICATION, authenticate);
    }

    public Authenticate getCurrentAuthenticate() {
        return getObjectFromPreference(AUTHENTICATION, Authenticate.class);
    }

    private void registerPreference (String key, Object o) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(PullmanApplication.getInstace());
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString(key, gson.toJson(o));

        editor.apply();
    }

    private <T> T getObjectFromPreference(String key, Class<T> clazz) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(PullmanApplication.getInstace());
        String jsonAuth = preferences.getString(key, "");

        if(!jsonAuth.equals("")) {
            return gson.fromJson(jsonAuth, clazz);
        }

        return null;
    }

    public void logout() {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(PullmanApplication.getInstace());
        SharedPreferences.Editor editor = preferences.edit();
        editor.remove(AUTHENTICATION);
        editor.apply();
    }
}
