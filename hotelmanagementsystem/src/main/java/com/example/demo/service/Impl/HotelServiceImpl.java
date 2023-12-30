package com.example.demo.service.Impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.demo.entity.Hotel;
import com.example.demo.entity.Room;
import com.example.demo.exceptionhandling.HotelNotFoundException;
import com.example.demo.repository.HotelRepository;
import com.example.demo.repository.RoomRepository;
import com.example.demo.service.HotelService;

@Service
public class HotelServiceImpl implements HotelService {

    @Autowired
    private HotelRepository hotelRepository;
    @Autowired
    RoomRepository roomRepository;

    @Override
    public Hotel createHotel(Hotel hotel) {
        return hotelRepository.save(hotel);
    }
    
 

    @Override
    public Hotel updateHotel(int hotelId, Hotel updatedHotel) {
        Hotel existingHotel = hotelRepository.findById(hotelId).orElse(null);

        if (existingHotel != null) {
            existingHotel.setHotelName(updatedHotel.getHotelName());
            existingHotel.setAddress(updatedHotel.getAddress());
            existingHotel.setPhoneNumber(updatedHotel.getPhoneNumber());

            return hotelRepository.save(existingHotel);
        } else {
            throw new HotelNotFoundException(hotelId);
        }
    }

    @Override
    public void deleteHotel(int hotelId) {
        hotelRepository.deleteById(hotelId);
    }

    @Override
    public Hotel getHotelById(int hotelId) {
        return hotelRepository.findById(hotelId)
                .orElseThrow(() -> new HotelNotFoundException(hotelId));
    }

    @Override
    public Iterable<Hotel> getAllHotels() {
        return hotelRepository.findAll();
    }

	
}