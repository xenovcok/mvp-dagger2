package com.bmt.zicreative.maidas.models;

/**
 * Created By Herwin DJ on 9/7/2018
 **/

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Authenticate {

    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("token")
    @Expose
    private String token;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

}