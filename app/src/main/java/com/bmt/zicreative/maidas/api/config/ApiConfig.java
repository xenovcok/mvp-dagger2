package com.bmt.zicreative.maidas.api.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public final class ApiConfig {
    public static final Gson GSON = new GsonBuilder()
            .create();
}
