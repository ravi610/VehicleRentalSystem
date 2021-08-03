package com.lld.vehiclerental.repository;

import com.lld.vehiclerental.model.Booking;
import com.lld.vehiclerental.model.enums.BookingStatus;
import com.lld.vehiclerental.model.Vehicle;

import java.util.HashMap;
import java.util.Map;

public class BookingRepository {
    Map<String, Booking> vehicleBookings;

    public BookingRepository() {
        vehicleBookings = new HashMap<>();
    }

    public Booking bookVehicle(Vehicle vehicle, String branchId, String userId, Integer hour, Boolean highDemand) {
        Double bookingCostPerHour = vehicle.getPricePerHour() * (1 + 0.1 * (highDemand ? 1 : 0));
        Booking booking = new Booking(bookingCostPerHour, branchId, userId, hour, vehicle);
        vehicleBookings.put(booking.getBookingId(), booking);

        return booking;
    }

    public Booking cancelBooking(String bookingId) {
        Booking booking = vehicleBookings.get(bookingId);
        booking.setBookingStatus(BookingStatus.CANCELLED);

        return booking;
    }

    public Booking getBookingById(String bookingId) {
        return vehicleBookings.getOrDefault(bookingId, null);
    }
}
