package com.lld.vehiclerental.repository;

import com.lld.vehiclerental.model.Bike;
import com.lld.vehiclerental.model.Car;
import com.lld.vehiclerental.model.Vehicle;

import java.util.*;

public class VehicleRepository {
    Map<String, List<Vehicle>> branchVehicleInventoryMap;
    Map<String, Integer> branchVehiclesCountMap;
    Map<String, String> vehicleBranchMap;

    public VehicleRepository() {
        branchVehicleInventoryMap = new HashMap<>();
        branchVehiclesCountMap = new HashMap<>();
        vehicleBranchMap = new HashMap<>();
    }

    public String onboardVehicle(String branchId, Vehicle vehicle) {
        if(!branchVehiclesCountMap.containsKey(branchId))
            branchVehiclesCountMap.put(branchId, 1);
        else
            branchVehiclesCountMap.put(branchId, branchVehiclesCountMap.get(branchId) + 1);

        vehicleBranchMap.put(vehicle.getVehicleId(), branchId);
        return addVehicle(branchId, vehicle);
    }

    public String offBoardVehicle(String branchId, Vehicle vehicle) {
        branchVehiclesCountMap.put(branchId, branchVehiclesCountMap.get(branchId) - 1);
        vehicleBranchMap.remove(vehicle.getVehicleId());
        return removeVehicle(branchId, vehicle);
    }

    public String addVehicle(String branchId, Vehicle vehicle) {
        if(!branchVehicleInventoryMap.containsKey(branchId))
            branchVehicleInventoryMap.put(branchId, new ArrayList<>(){{add(vehicle);}});
        else
            branchVehicleInventoryMap.get(branchId).add(vehicle);

        return vehicle.getVehicleId();
    }

    public String removeVehicle(String branchId, Vehicle vehicle) {
        branchVehicleInventoryMap.get(branchId).remove(vehicle);
        return vehicle.getVehicleId();
    }

    public List<Vehicle> getVehiclesByBranch(String branchId) {
        List<Vehicle> vehicles = branchVehicleInventoryMap.get(branchId);
        vehicles.sort((v1, v2) -> {
            if(v1.getPricePerHour() < v2.getPricePerHour())
                return -1;
            else if(v1.getPricePerHour().equals(v2.getPricePerHour()))
                return 0;
            return 1;
        });

        return vehicles;
    }

    public Boolean isVehicleAvailable(String branchId, Vehicle vehicle) {
        List<Vehicle> vehicles = branchVehicleInventoryMap.get(branchId);
        for(Vehicle vehicle1 : vehicles) {
            if(vehicle1.equals(vehicle))
                return true;
        }

        return false;
    }

    public Integer getNumberOfVehicleAvailable(String branchId) {
        List<Vehicle> vehicles = branchVehicleInventoryMap.getOrDefault(branchId, Collections.emptyList());
        return vehicles.size();
    }

    public Integer getMaxVehicleCountByBranch(String branchId) {
        return branchVehiclesCountMap.getOrDefault(branchId, 0);
    }

    public String getBranchIdByVehicleId(String vehicleId) {
        return vehicleBranchMap.getOrDefault(vehicleId, null);
    }
}
