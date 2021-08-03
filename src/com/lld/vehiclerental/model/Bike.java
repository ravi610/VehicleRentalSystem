package com.lld.vehiclerental.model;

import com.lld.vehiclerental.model.enums.BikeType;

public class Bike extends Vehicle {
    private BikeType bikeType;

    public Bike(String licencePlateNumber, String vehicleName, Double pricePerHour, BikeType bikeType) {
        super(licencePlateNumber, vehicleName, pricePerHour);
        this.bikeType = bikeType;
    }

    public BikeType getBikeType() {
        return bikeType;
    }

    public void setBikeType(BikeType bikeType) {
        this.bikeType = bikeType;
    }
}
