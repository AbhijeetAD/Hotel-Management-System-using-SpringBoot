package com.example.demo.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Booking;
import com.example.demo.exceptionhandling.BookingNotFoundException;
import com.example.demo.repository.BookingRepository;
import com.example.demo.service.BookingService;
@Service
public class BookingServiceImpl implements BookingService {

	 @Autowired
	    private BookingRepository bookingRepository;

	    @Override
	    public Booking createBooking(Booking booking) {
	    	
	            
	            booking.calculateTotalCost();

	        // Save the booking to the database
	        return bookingRepository.save(booking);
	    }

	    public Booking updateBooking(int bookingId, Booking updatedBooking) {
	        Booking existingBooking = bookingRepository.findById(bookingId).orElse(null);

	        if (existingBooking != null) {
	            existingBooking.setRoomNumber(updatedBooking.getRoomNumber());
	            existingBooking.setCheckInDate(updatedBooking.getCheckInDate());
	            existingBooking.setCheckOutDate(updatedBooking.getCheckOutDate());
	            existingBooking.setBreakfastIncluded(updatedBooking.isBreakfastIncluded());
	            

	            // Update total cost based on breakfast inclusion
	          

	            return bookingRepository.save(existingBooking);
	        } else {
	            throw new BookingNotFoundException(bookingId);
	        }
	    }

	    @Override
	    public void deleteBooking(int bookingId) {
	        bookingRepository.deleteById(bookingId);
	    }

	    @Override
	    public Booking getBookingById(int bookingId) {
	        return bookingRepository.findById(bookingId)
	                .orElseThrow(() -> new BookingNotFoundException(bookingId));
	    }

	    @Override
	    public Iterable<Booking> getAllBookings() {
	        return bookingRepository.findAll();
	    }
	}