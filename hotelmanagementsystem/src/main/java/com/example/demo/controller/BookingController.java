package com.example.demo.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.example.demo.entity.Booking;
import com.example.demo.exceptionhandling.BookingNotFoundException;
import com.example.demo.service.BookingService;


import jakarta.validation.Valid;

@RestController
public class BookingController {
    @Autowired
    BookingService bookingService;
	@PostMapping("/booking")
	public ResponseEntity<Booking> createBooking(@Valid @RequestBody Booking b) {
		Booking b1 = bookingService.createBooking(b);
		return new ResponseEntity<Booking>(b1, HttpStatus.CREATED);
	}
	 @PutMapping("/booking/{bookingId}")
	    public ResponseEntity<Booking> updateBooking(
	            @PathVariable int bookingId,
	            @RequestBody Booking updatedBooking) {
	        Booking updated = bookingService.updateBooking(bookingId, updatedBooking);
			return new ResponseEntity<>(updated, HttpStatus.OK);
	    }
	@DeleteMapping("/booking/{bookingId}")
    public ResponseEntity<Void> deleteBooking(@PathVariable int bookingId) {
        bookingService.deleteBooking(bookingId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

	 @GetMapping("/booking/{bookingId}")
	    public ResponseEntity<Booking> getBookingById(@PathVariable int bookingId) {
	        try {
	            Booking booking = bookingService.getBookingById(bookingId);
	            return new ResponseEntity<>(booking, HttpStatus.OK);
	        } catch (BookingNotFoundException ex) {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	    }

    @GetMapping("/bookings")
    public ResponseEntity<Iterable<Booking>> getAllBookings() {
        Iterable<Booking> bookings = bookingService.getAllBookings();
        return new ResponseEntity<>(bookings, HttpStatus.OK);
    }
}



