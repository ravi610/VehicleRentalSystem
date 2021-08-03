package com.lld.vehiclerental.model;

import com.lld.vehiclerental.utils.CommonUtils;

public abstract class Vehicle {
    private String vehicleId;
    private String vehicleName;
    private String licencePlateNumber;
    private Double pricePerHour;

    public Vehicle(String licencePlateNumber, String vehicleName, Double pricePerHour) {
        this.vehicleId = CommonUtils.generateUuid(15);
        this.licencePlateNumber = licencePlateNumber;
        this.vehicleName = vehicleName;
        this.pricePerHour = pricePerHour;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getLicencePlateNumber() {
        return licencePlateNumber;
    }

    public void setLicencePlateNumber(String licencePlateNumber) {
        this.licencePlateNumber = licencePlateNumber;
    }

    public Double getPricePerHour() {
        return pricePerHour;
    }

    public void setPricePerHour(Double pricePerHour) {
        this.pricePerHour = pricePerHour;
    }

    public String getVehicleName() {
        return vehicleName;
    }

    public void setVehicleName(String vehicleName) {
        this.vehicleName = vehicleName;
    }
}
