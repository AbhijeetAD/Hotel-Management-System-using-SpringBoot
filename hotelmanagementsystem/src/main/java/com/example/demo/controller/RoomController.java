package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Booking;
import com.example.demo.entity.Room;
import com.example.demo.exceptionhandling.BookingNotFoundException;
import com.example.demo.exceptionhandling.RoomNotFoundException;
import com.example.demo.service.RoomService;
import com.example.demo.service.Impl.RoomServiceImpl;

import jakarta.validation.Valid;

@RestController

@Validated
public class RoomController {

    @Autowired
    private RoomService roomService;

    @PostMapping("/room")
    public ResponseEntity<Room> createRoom(@Valid @RequestBody Room room) {
        Room createdRoom = roomService.createRoom(room);
        
        return new ResponseEntity<>(createdRoom, HttpStatus.CREATED);
    }

    @PutMapping("/room/{roomId}")
    public ResponseEntity<Room> updateRoom(
            @PathVariable int roomId,
            @Valid @RequestBody Room updatedRoom) {
        try {
            Room updated = roomService.updateRoom(roomId, updatedRoom);
            return new ResponseEntity<>(updated, HttpStatus.OK);
        } catch (RoomNotFoundException ex) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/room/{roomId}")
    public ResponseEntity<Void> deleteRoom(@PathVariable int roomId) {
        roomService.deleteRoom(roomId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/room/{roomId}")
    public ResponseEntity<Room> getRoomById(@PathVariable int roomId) {
        try {
            Room room = roomService.getRoomById(roomId);
            return new ResponseEntity<>(room, HttpStatus.OK);
        } catch (RoomNotFoundException ex) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/rooms")
    public ResponseEntity<Iterable<Room>> getAllRooms() {
        Iterable<Room> rooms = roomService.getAllRooms();
        return new ResponseEntity<>(rooms, HttpStatus.OK);
    }
}