package com.example.demo.service;



import com.example.demo.entity.Hotel;
import com.example.demo.entity.Room;


public interface HotelService {

	Hotel createHotel(Hotel hotel);

    Hotel updateHotel(int hotelId, Hotel updatedHotel);

    void deleteHotel(int hotelId);

    Hotel getHotelById(int hotelId);

    Iterable<Hotel> getAllHotels();

     

}
	



