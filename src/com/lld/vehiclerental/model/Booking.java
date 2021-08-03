package com.lld.vehiclerental.model;

import com.lld.vehiclerental.model.enums.BookingStatus;
import com.lld.vehiclerental.utils.CommonUtils;

public class Booking {
    private String bookingId;
    private Double costPerHour;
    private String branchId;
    private String userId;
    private Integer bookingTime;
    private BookingStatus bookingStatus;
    private Vehicle vehicle;

    public Booking(Double costPerHour, String branchId, String userId, Integer bookingTime, Vehicle vehicle) {
        this.bookingId = CommonUtils.generateUuid(15);
        this.costPerHour = costPerHour;
        this.branchId = branchId;
        this.userId = userId;
        this.bookingTime = bookingTime;
        this.bookingStatus = BookingStatus.ACTIVE;
        this.vehicle = vehicle;
    }

    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public Double getCostPerHour() {
        return costPerHour;
    }

    public void setCostPerHour(Double costPerHour) {
        this.costPerHour = costPerHour;
    }

    public String getBranchId() {
        return branchId;
    }

    public void setBranchId(String branchId) {
        this.branchId = branchId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Integer getBookingTime() {
        return bookingTime;
    }

    public void setBookingTime(Integer bookingTime) {
        this.bookingTime = bookingTime;
    }

    public BookingStatus getBookingStatus() {
        return bookingStatus;
    }

    public void setBookingStatus(BookingStatus bookingStatus) {
        this.bookingStatus = bookingStatus;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
}
