package com.bmt.zicreative.maidas.booking;

import com.bmt.zicreative.maidas.models.Barber;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

public interface ShopService {
    @GET("shop")
    Observable<List<BarbershopModel>> getShopList();

    @GET("users/role/{role_id}")
    Observable<List<Barber>> getUserByRole(@Path("role_id") String roleId);
}
