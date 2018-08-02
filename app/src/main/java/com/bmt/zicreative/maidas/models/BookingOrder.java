package com.bmt.zicreative.maidas.models;

/**
 * Created By Herwin DJ on 8/2/2018
 **/

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BookingOrder {

    @SerializedName("_id")
    @Expose
    private String id;
    @SerializedName("user_id")
    @Expose
    private String userId;
    @SerializedName("barberman_id")
    @Expose
    private String barbermanId;
    @SerializedName("product_id")
    @Expose
    private String productId;
    @SerializedName("book_for_date")
    @Expose
    private String bookForDate;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("total")
    @Expose
    private String total;
    @SerializedName("book_id")
    @Expose
    private String bookId;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("__v")
    @Expose
    private Integer v;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getBarbermanId() {
        return barbermanId;
    }

    public void setBarbermanId(String barbermanId) {
        this.barbermanId = barbermanId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getBookForDate() {
        return bookForDate;
    }

    public void setBookForDate(String bookForDate) {
        this.bookForDate = bookForDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public Integer getV() {
        return v;
    }

    public void setV(Integer v) {
        this.v = v;
    }

}
