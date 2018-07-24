package com.bmt.zicreative.maidas.github;

import com.bmt.zicreative.maidas.models.Github;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created By Herwin DJ on 7/24/2018
 **/

public interface GithubService {
    @GET("users/xenovcok")
    Observable<Github> getGithubData();
}
