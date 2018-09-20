package com.bmt.zicreative.maidas.booking;

import com.bmt.zicreative.maidas.api.ApiResponse;
import com.bmt.zicreative.maidas.booking.detail.OrderModel;
import com.bmt.zicreative.maidas.models.Barber;
import com.bmt.zicreative.maidas.models.BookingOrder;
import com.bmt.zicreative.maidas.models.Product;

import java.util.List;

import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import rx.Observable;

public interface ShopService {
    @GET("shop")
    Observable<List<BarbershopModel>> getShopList();

    @GET("users/role/{role_id}")
    Observable<List<Barber>> getUserByRole(@Path("role_id") String roleId);

    @GET("orderlist/{years}/{month}/dates")
    Observable<List<BookingOrder>> getOrderByDate(@Path("years") String years, @Path("month") String month);

    @GET("orderlist/{year}/{month}/{day}/day")
    Observable<List<BookingOrder>> getOrderByDay(@Path("year") String year, @Path("month") String month, @Path("day") String day);

    @GET("orderlist/{id}/me")
    Observable<List<BookingOrder>> getOrderByUserId(@Path("id") String userId);

    @GET("products")
    Observable<List<Product>> getAllProducts();

    @POST("orderlist")
    Observable<ApiResponse> addNewOrder(@Body OrderModel orderModel);
}
