package com.example.demo.exceptionhandling;

public class HotelNotFoundException extends RuntimeException {

    public HotelNotFoundException(int hotelId) {
        super("Hotel not found with id: " + hotelId);
    }
}