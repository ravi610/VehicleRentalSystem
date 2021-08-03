package com.lld.vehiclerental.service;

import com.lld.vehiclerental.model.*;

import java.util.List;

public class RentalService {
    private final VehicleService vehicleService;
    private final BookingService bookingService;
    private final BranchService branchService;
    private final BillingService billingService;

    public RentalService(VehicleService vehicleService, BookingService bookingService, BranchService branchService, BillingService billingService) {
        this.vehicleService = vehicleService;
        this.bookingService = bookingService;
        this.branchService = branchService;
        this.billingService = billingService;
    }

    public Booking rentVehicle(User user, Vehicle vehicle, Integer currentHourTime) {
        Boolean isVehicleAvailable = vehicleService.isVehicleAvailable(vehicle);
        String branchId = vehicleService.getBranchIdByVehicle(vehicle);
        Boolean isHighDemand = vehicleService.isHighDemand(branchId);
        if(!isVehicleAvailable) {
            System.out.println("Vehicle Not available. please select a different vehicle.");
            return null;
        }

        vehicleService.removeVehicle(vehicle);
        return bookingService.bookVehicle(vehicle, branchId, user.getUserId(), currentHourTime, isHighDemand);
    }

    public Booking rentMostEconomicVehicleByBranch(User user, RentalBranch branch, Integer currentHourTime) {
        List<Vehicle> vehicles = vehicleService.getVehiclesByBranch(branch.getRentalBranchId());
        Boolean isHighDemand = vehicleService.isHighDemand(branch.getRentalBranchId());

        if(vehicles.size() == 0) {
            System.out.println("No vehicles available at selected branch.");
            return null;
        }

        Vehicle vehicle = vehicles.get(0);
        vehicleService.removeVehicle(vehicle);
        return bookingService.bookVehicle(vehicle, branch.getRentalBranchId(), user.getUserId(), currentHourTime, isHighDemand);
    }

    public Booking cancelRentalBooking(Booking booking) {
        vehicleService.addVehicle(booking.getVehicle());
        return bookingService.cancelBooking(booking.getBookingId());
    }

    public BillReceipt finishTrip(User user, Booking booking, Integer endTime) {
        Vehicle vehicle = booking.getVehicle();
        vehicleService.addVehicle(vehicle);
        String branchId = vehicleService.getBranchIdByVehicle(vehicle);
        return billingService.generateBillReceipt(booking.getBookingId(), vehicle.getPricePerHour(), user.getUserId(), branchId, vehicle.getVehicleId(), booking.getBookingTime(), endTime);
    }
}
