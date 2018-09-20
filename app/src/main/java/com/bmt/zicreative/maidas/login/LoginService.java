package com.bmt.zicreative.maidas.login;

import com.bmt.zicreative.maidas.models.Authenticate;

import io.reactivex.Flowable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created By Herwin DJ on 9/7/2018
 **/

public interface LoginService {
    @FormUrlEncoded
    @POST("oauth/token")
    Flowable<Authenticate> authenticate(@Field("username") String username,
                                        @Field("password") String password);
}
