package com.lld.vehiclerental.model;

import com.lld.vehiclerental.model.enums.CarType;

public class Car extends Vehicle{
    private CarType carType;

    public Car(String licencePlateNumber, String vehicleName, Double pricePerHour, CarType carType) {
        super(licencePlateNumber, vehicleName, pricePerHour);
        this.carType = carType;
    }

    public CarType getCarType() {
        return carType;
    }

    public void setCarType(CarType carType) {
        this.carType = carType;
    }
}
