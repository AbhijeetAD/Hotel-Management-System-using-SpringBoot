package com.example.demo.exceptionhandling;

import java.net.http.HttpHeaders;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;





@ControllerAdvice
	public class CustomGlobalExceptionHandler extends ResponseEntityExceptionHandler {
	private String comment = "comment";

	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		// TODO Auto-generated method stub
		Map<String, String> errors = new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach((error) -> {

			String fieldName = ((FieldError) error).getField();
			String message = error.getDefaultMessage();
			errors.put(fieldName, message);
		});
		return new ResponseEntity<Object>(errors, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(CustomerNotFoundException.class)
	public ResponseEntity<Object> handleCustomerException(CustomerNotFoundException ex) {
		return null;
	}
		@ExceptionHandler(BookingNotFoundException.class)
		public ResponseEntity<Object> handleBookingException1(BookingNotFoundException ex) {
			return null;
			}
		
		@ExceptionHandler(HotelNotFoundException.class)
		public ResponseEntity<Object> handleHotelException(HotelNotFoundException ex) {
			return null;
			}
		
		@ExceptionHandler(ManagerNotFoundException.class)
		public ResponseEntity<Object> handleManagerException(ManagerNotFoundException ex) {
			return null;
			}
		
		@ExceptionHandler(ReviewsNotFoundException.class)
		public ResponseEntity<Object> handleReviewsException(ReviewsNotFoundException ex) {
			return null;
			}
		
		@ExceptionHandler(RoomNotFoundException.class)
		public ResponseEntity<Object> handleRoomException(RoomNotFoundException ex) {
			return null;
			}
		
		@ExceptionHandler(AdminNotFoundException.class)
		public ResponseEntity<Object> handleAdminException(AdminNotFoundException ex) {
			return null;
			}

}