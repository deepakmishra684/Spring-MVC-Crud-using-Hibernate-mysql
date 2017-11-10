package com.deepak.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.deepak.spring.dao.HotelDao;
import com.deepak.spring.entity.Hotel;

@Service
public class HotelServiceImpl implements HotelService {

	@Autowired
	private HotelDao hotelDao;
	
	public void setHotelDao(HotelDao hotelDao) {
		this.hotelDao = hotelDao;
	}

	@Override
	@Transactional
	public Long saveHotel(Hotel hotel) {
		// TODO Auto-generated method stub
		return hotelDao.saveHotel(hotel);
	}

	@Override
	@Transactional
	public Hotel getHotel(Long hotelId) {
		// TODO Auto-generated method stub
		return hotelDao.getHotel(hotelId);
	}

	@Override
	@Transactional
	public List<Hotel> getAllHotels() {
		// TODO Auto-generated method stub
		return hotelDao.getAllHotels();
	}

	@Override
	@Transactional
	public void updateHotel(Hotel hotel) {
		// TODO Auto-generated method stub
		hotelDao.updateHotel(hotel);
	}

	@Override
	@Transactional
	public void deleteHotel(Long hotelId) {
		// TODO Auto-generated method stub
		hotelDao.deleteHotel(hotelId);
	}

}
