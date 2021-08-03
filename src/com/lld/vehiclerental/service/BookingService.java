package com.lld.vehiclerental.service;

import com.lld.vehiclerental.model.Booking;
import com.lld.vehiclerental.model.Vehicle;
import com.lld.vehiclerental.repository.BookingRepository;

public class BookingService {
    private BookingRepository bookingRepository;

    public BookingService() {
        bookingRepository = new BookingRepository();
    }

    public Booking bookVehicle(Vehicle vehicle, String branchId, String userId, Integer hour, Boolean highDemand) {
        return bookingRepository.bookVehicle(vehicle, branchId, userId, hour, highDemand);
    }

    public Booking cancelBooking(String bookingId) {
        return bookingRepository.cancelBooking(bookingId);
    }

    public Booking getBookingById(String bookingId) {
        return bookingRepository.getBookingById(bookingId);
    }


}
