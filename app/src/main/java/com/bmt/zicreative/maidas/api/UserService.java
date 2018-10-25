package com.bmt.zicreative.maidas.api;

import com.bmt.zicreative.maidas.models.User;

import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created By Herwin DJ on 10/23/2018
 **/

public interface UserService {
    @POST("users")
    rx.Observable<ApiResponse> saveUser(@Body User user);

    @GET("users/{id}")
    Observable<User> getUserByEmail(@Path("id") String email);
}
