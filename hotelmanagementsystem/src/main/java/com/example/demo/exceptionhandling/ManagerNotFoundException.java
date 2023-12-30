package com.example.demo.exceptionhandling;

public class ManagerNotFoundException extends RuntimeException {

    public ManagerNotFoundException(int managerId) {
        super("Manager not found with id: " + managerId);
    }
}