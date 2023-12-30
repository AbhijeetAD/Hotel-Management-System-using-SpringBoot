package com.example.demo.exceptionhandling;

public class AdminNotFoundException extends RuntimeException {

    public AdminNotFoundException(int id) {
        super("Admin not found with id: " + id);
    }


}
