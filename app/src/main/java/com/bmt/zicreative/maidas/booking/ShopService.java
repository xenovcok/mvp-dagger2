package com.bmt.zicreative.maidas.booking;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import rx.Observable;

public interface ShopService {
    @GET("shop")
    Observable<BarbershopModel> getShopList();
}
