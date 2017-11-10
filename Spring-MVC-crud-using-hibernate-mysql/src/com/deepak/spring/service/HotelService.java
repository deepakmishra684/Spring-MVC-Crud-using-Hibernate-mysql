package com.deepak.spring.service;

import java.util.List;

import com.deepak.spring.entity.Hotel;

public interface HotelService {
	Long saveHotel(Hotel hotel);
	Hotel getHotel(Long hotelId);
	List<Hotel> getAllHotels();
	void updateHotel(Hotel hotel);
	void deleteHotel(Long hotelId);
}
