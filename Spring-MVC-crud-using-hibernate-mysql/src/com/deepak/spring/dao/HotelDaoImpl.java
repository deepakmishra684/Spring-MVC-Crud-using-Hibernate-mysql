package com.deepak.spring.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.deepak.spring.entity.Hotel;

@Repository
public class HotelDaoImpl implements HotelDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public Long saveHotel(Hotel hotel) {
		Session session = sessionFactory.openSession();
		return (Long)session.save(hotel);
	}

	@Override
	public Hotel getHotel(Long hotelId) {
		return sessionFactory.openSession().get(Hotel.class, hotelId);
	}

	@Override
	public List<Hotel> getAllHotels() {
		Query query = sessionFactory.openSession().createQuery("from Hotel");
		return query.list();
	}

	@Override
	public void updateHotel(Hotel hotel) {
		Session session = sessionFactory.openSession();
		Transaction txn = session.beginTransaction();
		session.update(hotel);
		txn.commit();
	}

	@Override
	public void deleteHotel(Long hotelId) {
		Session session = sessionFactory.openSession();
		Transaction txn = session.beginTransaction();
		Hotel hotel = session.get(Hotel.class, hotelId);
		session.delete(hotel);
		txn.commit();
	}
}
