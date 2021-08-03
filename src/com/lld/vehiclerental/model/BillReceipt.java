package com.lld.vehiclerental.model;

import com.lld.vehiclerental.utils.CommonUtils;

public class BillReceipt {
    private String billReceiptId;
    private String bookingId;
    private Double amount;
    private String userId;
    private String branchId;
    private String vehicleId;
    private Integer startTime;
    private Integer endTime;

    public BillReceipt(String bookingId, Double amount, String userId, String branchId, String vehicleId, Integer startTime, Integer endTime) {
        this.billReceiptId = CommonUtils.generateUuid(15);
        this.bookingId = bookingId;
        this.amount = amount;
        this.userId = userId;
        this.branchId = branchId;
        this.vehicleId = vehicleId;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public String getBillReceiptId() {
        return billReceiptId;
    }

    public void setBillReceiptId(String billReceiptId) {
        this.billReceiptId = billReceiptId;
    }

    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getBranchId() {
        return branchId;
    }

    public void setBranchId(String branchId) {
        this.branchId = branchId;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId;
    }

    public Integer getStartTime() {
        return startTime;
    }

    public void setStartTime(Integer startTime) {
        this.startTime = startTime;
    }

    public Integer getEndTime() {
        return endTime;
    }

    public void setEndTime(Integer endTime) {
        this.endTime = endTime;
    }
}
