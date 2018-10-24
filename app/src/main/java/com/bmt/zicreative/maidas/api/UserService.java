package com.bmt.zicreative.maidas.api;

import com.bmt.zicreative.maidas.models.User;

import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created By Herwin DJ on 10/23/2018
 **/

public interface UserService {
    @POST("users")
    rx.Observable<ApiResponse> saveUser(@Body User user);
}
