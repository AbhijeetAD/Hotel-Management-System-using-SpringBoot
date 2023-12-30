package com.example.demo.service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.demo.entity.Room;
import com.example.demo.exceptionhandling.RoomNotFoundException;
import com.example.demo.repository.RoomRepository;
import com.example.demo.service.RoomService;


@Service
public class RoomServiceImpl implements RoomService {

    @Autowired
    private RoomRepository roomRepository;

    @Override
    public Room createRoom(Room room) {
        return roomRepository.save(room);
    }

    @Override
    public Room updateRoom(int roomId, Room updatedRoom) {
        Room existingRoom = roomRepository.findById(roomId).orElse(null);

        if (existingRoom != null) {
            existingRoom.setRoomNumber(updatedRoom.getRoomNumber());
            existingRoom.setCapacity(updatedRoom.getCapacity());

            // Update other room-related fields as needed

            return roomRepository.save(existingRoom);
        } else {
            throw new RoomNotFoundException(roomId);
        }
    }

    @Override
    public void deleteRoom(int roomId) {
        roomRepository.deleteById(roomId);
    }

    @Override
    public Room getRoomById(int roomId) {
        return roomRepository.findById(roomId)
                .orElseThrow(() -> new RoomNotFoundException(roomId));
    }

    @Override
    public Iterable<Room> getAllRooms() {
        return roomRepository.findAll();
    }
}