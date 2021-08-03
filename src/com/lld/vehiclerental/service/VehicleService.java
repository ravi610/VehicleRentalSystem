package com.lld.vehiclerental.service;

import com.lld.vehiclerental.model.Vehicle;
import com.lld.vehiclerental.repository.VehicleRepository;

import java.util.List;

public class VehicleService {
    private final VehicleRepository vehicleRepository;

    public VehicleService() {
        vehicleRepository = new VehicleRepository();
    }

    public String onBoardVehicle(String branchId, Vehicle vehicle) {
        return vehicleRepository.onboardVehicle(branchId, vehicle);
    }

    public String offBoardVehicle(String branchId, Vehicle vehicle) {
        return vehicleRepository.offBoardVehicle(branchId, vehicle);
    }

    public String addVehicle(Vehicle vehicle) {
        String branchId = vehicleRepository.getBranchIdByVehicleId(vehicle.getVehicleId());
        return vehicleRepository.addVehicle(branchId, vehicle);
    }

    public String removeVehicle(Vehicle vehicle) {
        String branchId = vehicleRepository.getBranchIdByVehicleId(vehicle.getVehicleId());
        return vehicleRepository.removeVehicle(branchId, vehicle);
    }

    public List<Vehicle> getVehiclesByBranch(String branchId) {
        return vehicleRepository.getVehiclesByBranch(branchId);
    }

    public Boolean isVehicleAvailable(Vehicle vehicle) {
        String branchId = vehicleRepository.getBranchIdByVehicleId(vehicle.getVehicleId());
        return vehicleRepository.isVehicleAvailable(branchId, vehicle);
    }

    public Boolean isHighDemand(String branchId) {
        int maxVehiclesCount = vehicleRepository.getMaxVehicleCountByBranch(branchId);
        int availableVehiclesCount = vehicleRepository.getNumberOfVehicleAvailable(branchId);
        int percentAvailableVehicles = (availableVehiclesCount * 100) / maxVehiclesCount;

        return percentAvailableVehicles <= 20;
    }

    public String getBranchIdByVehicle(Vehicle vehicle) {
        return vehicleRepository.getBranchIdByVehicleId(vehicle.getVehicleId());
    }
}
