package com.bmt.zicreative.maidas.booking.detail;

import java.util.List;

/**
 * Created By Herwin DJ on 8/31/2018
 **/

public class OrderModel {
    private String userId;
    private List<String> productId;
    private String barbermanId;
    private String createdAt;
    private String processedAt;
    private String heldDate;
    private String status;
    private String total;
    private String bookId;

    public OrderModel() {

    }

    public OrderModel(String userId, List<String> productId, String barbermanId, String createdAt, String processedAt, String heldDate, String status, String total, String bookId) {
        this.userId = userId;
        this.productId = productId;
        this.barbermanId = barbermanId;
        this.createdAt = createdAt;
        this.processedAt = processedAt;
        this.heldDate = heldDate;
        this.status = status;
        this.total = total;
        this.bookId = bookId;

    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public List<String> getProductId() {
        return productId;
    }

    public void setProductId(List<String> productId) {
        this.productId = productId;
    }

    public String getBarbermanId() {
        return barbermanId;
    }

    public void setBarbermanId(String barbermanId) {
        this.barbermanId = barbermanId;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getProcessedAt() {
        return processedAt;
    }

    public void setProcessedAt(String processedAt) {
        this.processedAt = processedAt;
    }

    public String getHeldDate() {
        return heldDate;
    }

    public void setHeldDate(String heldDate) {
        this.heldDate = heldDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        status = status;
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
}
