package com.example.demo.exceptionhandling;

public class CustomerNotFoundException extends RuntimeException {

    public CustomerNotFoundException(int customerId) {
        super("Customer not found with id: " + customerId);
    }
}