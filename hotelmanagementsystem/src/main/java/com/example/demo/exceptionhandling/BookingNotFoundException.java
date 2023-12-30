package com.example.demo.exceptionhandling;

public class BookingNotFoundException extends RuntimeException {

    public BookingNotFoundException(int bookingId) {
        super("Booking not found with id: " + bookingId);
    }
}