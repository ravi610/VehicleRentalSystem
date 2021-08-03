package com.lld.vehiclerental.model;

import com.lld.vehiclerental.utils.CommonUtils;

import java.util.HashMap;
import java.util.Map;

public class RentalBranch {
    private String rentalBranchId;
    private String city;
    private String branchName;
    private Map<Vehicle, Integer> vehiclesList;

    public RentalBranch() {
        this.rentalBranchId = CommonUtils.generateUuid(15);
        vehiclesList = new HashMap<>();
    }

    public RentalBranch(String city, String branchName) {
        this.rentalBranchId = CommonUtils.generateUuid(15);
        this.city = city;
        this.branchName = branchName;
        vehiclesList = new HashMap<>();
    }

    public String getRentalBranchId() {
        return rentalBranchId;
    }

    public void setRentalBranchId(String rentalBranchId) {
        this.rentalBranchId = rentalBranchId;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public Map<Vehicle, Integer> getVehiclesList() {
        return vehiclesList;
    }

    public void setVehiclesList(Map<Vehicle, Integer> vehiclesList) {
        this.vehiclesList = vehiclesList;
    }
}
