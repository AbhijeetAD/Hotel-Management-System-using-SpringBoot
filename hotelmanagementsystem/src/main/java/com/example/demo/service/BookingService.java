package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Booking;
import com.example.demo.exceptionhandling.BookingNotFoundException;



public interface BookingService {
	
	Booking createBooking(Booking booking);

    Booking updateBooking(int bookingId, Booking updatedBooking);

    void deleteBooking(int bookingId);

    Booking getBookingById(int bookingId) throws BookingNotFoundException;

    Iterable<Booking> getAllBookings();

}
