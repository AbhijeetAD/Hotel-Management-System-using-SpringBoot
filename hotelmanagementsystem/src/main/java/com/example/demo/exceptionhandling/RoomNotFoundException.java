package com.example.demo.exceptionhandling;

public class RoomNotFoundException extends RuntimeException {

    public RoomNotFoundException(int roomId) {
        super("Room not found with id: " + roomId);
    }
}