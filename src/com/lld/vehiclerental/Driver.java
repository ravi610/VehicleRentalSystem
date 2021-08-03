package com.lld.vehiclerental;

import com.lld.vehiclerental.model.*;
import com.lld.vehiclerental.model.enums.BikeType;
import com.lld.vehiclerental.model.enums.CarType;
import com.lld.vehiclerental.service.*;

import java.util.List;

public class Driver {

    public static void main(String[] args) {
        BranchService branchService = new BranchService();
        VehicleService vehicleService = new VehicleService();
        BookingService bookingService = new BookingService();
        BillingService billingService = new BillingService();
        RentalService rentalService = new RentalService(vehicleService, bookingService, branchService, billingService);

        // users
        User user1 = new User("dummy-licence-1", "99xxxxxxx1", "ravixxxx1@gmail.com");
        User user2 = new User("dummy-licence-2", "99xxxxxxx2", "ravixxxx2@gmail.com");
        User user3 = new User("dummy-licence-3", "99xxxxxxx3", "ravixxxx3@gmail.com");
        User user4 = new User("dummy-licence-4", "99xxxxxxx4", "ravixxxx4@gmail.com");
        User user5 = new User("dummy-licence-5", "99xxxxxxx5", "ravixxxx5@gmail.com");
        User user6 = new User("dummy-licence-6", "99xxxxxxx6", "ravixxxx6@gmail.com");


        // on boarding a branch
        RentalBranch branch1 = branchService.onboardBranch("Bangalore", "whitefield");
        RentalBranch branch2 = branchService.onboardBranch("Bangalore", "Domlur");
        RentalBranch branch3 = branchService.onboardBranch("Bangalore", "Indra Nagar");
        RentalBranch branch4 = branchService.onboardBranch("Bangalore", "Kormangala");

        // printing all branch names of branches onboarded.
        System.out.println("Printing onboarded branches : ");
        branchService.getAllBranches().forEach(branch -> {System.out.println(branch.getBranchName());});
        System.out.println();

        // Creating some Vehicles
        Vehicle vehicle1 = new Car("dummy-licence-1", "Indica",100.00, CarType.FOUR_SEATER_CAR);
        Vehicle vehicle2 = new Car("dummy-licence-2", "Micra", 200.00, CarType.FOUR_SEATER_CAR);
        Vehicle vehicle3 = new Car("dummy-licence-3", "Swift",250.00, CarType.SIX_SEATER_CAR);
        Vehicle vehicle4 = new Car("dummy-licence-4", "Fortuner", 300.00, CarType.SIX_SEATER_CAR);
        Vehicle vehicle5 = new Bike("dummy-licence-5", "Apache",100.00, BikeType.MOTOR_BIKE);
        Vehicle vehicle6 = new Bike("dummy-licence-6", "FZ",200.00, BikeType.MOTOR_BIKE);
        Vehicle vehicle7 = new Bike("dummy-licence-7", "pep+",50.00, BikeType.SCOOTY);

        // on boarding vehicles
        vehicleService.onBoardVehicle(branch1.getRentalBranchId(), vehicle1);
        vehicleService.onBoardVehicle(branch1.getRentalBranchId(), vehicle2);
        vehicleService.onBoardVehicle(branch2.getRentalBranchId(), vehicle3);
        vehicleService.onBoardVehicle(branch2.getRentalBranchId(), vehicle4);
        vehicleService.onBoardVehicle(branch2.getRentalBranchId(), vehicle5);
        vehicleService.onBoardVehicle(branch2.getRentalBranchId(), vehicle6);
        vehicleService.onBoardVehicle(branch2.getRentalBranchId(), vehicle7);

        // printing all vehicles by branch
        System.out.println("Vehicles onboarded for branch 1 : ");
        vehicleService.getVehiclesByBranch(branch1.getRentalBranchId()).forEach(vehicle -> {
            System.out.println("vehicle_id : " + vehicle.getVehicleId() + "\nvehicle_name : " + vehicle.getVehicleName() + "\nlicence_plate : " + vehicle.getLicencePlateNumber() + "\n");
        });

        // Rent the cheapest vehicle automatically and a trip of 3 hours and respective billing and after the trip got completed the vehicle got parked to respective branch.
        Booking vehicleBooking = rentalService.rentMostEconomicVehicleByBranch(user1, branch1, 12);
        BillReceipt billReceipt = rentalService.finishTrip(user1, vehicleBooking, 15);
        System.out.println("Billing: ");
        System.out.println("receiptId: " + billReceipt.getBillReceiptId() + "\nbookingId: " + billReceipt.getBookingId() + "\namount: " + billReceipt.getAmount() + "\n");

        // display all vehicles sorted by price
        List<Vehicle> vehicles = vehicleService.getVehiclesByBranch(branch2.getRentalBranchId());

        System.out.println("Vehicles of branch 2 sorted by price per hour : ");
        vehicles.forEach(vehicle -> {
            System.out.println("VehicleId: " + vehicle.getVehicleId() + "\nVehicleName: "+ vehicle.getVehicleName() + "\npricePerHour: "+vehicle.getPricePerHour() + "\n");
        });

        // rent a vehicle during high demand
        Booking vehicleBooking2 = rentalService.rentMostEconomicVehicleByBranch(user2, branch2, 12);
        Booking vehicleBooking3 = rentalService.rentMostEconomicVehicleByBranch(user3, branch2, 12);
        Booking vehicleBooking4 = rentalService.rentMostEconomicVehicleByBranch(user4, branch2, 12);
        Booking vehicleBooking5 = rentalService.rentMostEconomicVehicleByBranch(user5, branch2, 12);

        //price for this booking will be inflated because only 20 vehicles are remaining.
        Booking vehicleBooking6 = rentalService.rentMostEconomicVehicleByBranch(user6, branch2, 12);
        System.out.println("Inflate cost by 10 % example : ");
        System.out.println("old Vehicle booking price : " + vehicleBooking6.getVehicle().getPricePerHour());
        System.out.println("new Vehicle booking price : " + vehicleBooking6.getCostPerHour());

        rentalService.finishTrip(user2, vehicleBooking2, 13);
        rentalService.finishTrip(user3, vehicleBooking3, 14);
        rentalService.finishTrip(user4, vehicleBooking4, 15);
        rentalService.finishTrip(user5, vehicleBooking5, 16);
        rentalService.finishTrip(user6, vehicleBooking6, 17);

        // All booking receipts
        System.out.println("\nAll Booking Receipts generated : ");
        List<BillReceipt> bills = billingService.getAllBillReceipts();

        bills.forEach(bill -> {
            System.out.println("billId : "+bill.getBillReceiptId() + "\namount : "+bill.getAmount()+"\n");
        });
    }
}
