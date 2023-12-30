package com.example.demo.service;

import java.util.List;


import com.example.demo.entity.Room;
import com.example.demo.exceptionhandling.RoomNotFoundException;

public interface RoomService {
	 Room createRoom(Room room);

	    Room updateRoom(int roomId, Room updatedRoom);

	    void deleteRoom(int roomId);

	    Room getRoomById(int roomId);

	    Iterable<Room> getAllRooms();
	}