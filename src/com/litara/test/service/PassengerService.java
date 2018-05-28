package com.litara.test.service;

import com.litara.test.dao.PassengerDAO;
import com.litara.test.entities.Passenger;

public class PassengerService extends AbstractService<Passenger> {

	@Override
	public void create(Passenger entity) {
		PassengerDAO passengerDAO = new PassengerDAO();
		passengerDAO.create(entity);
		
	}

	@Override
	public Passenger findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Passenger entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Passenger entity) {
		// TODO Auto-generated method stub
		
	}
	public boolean isExist(String email) {
		PassengerDAO passengerDAO=new PassengerDAO();
		return passengerDAO.findByEmail(email);
	}
	public boolean isExist(String email, String password) {
		PassengerDAO passengerDAO=new PassengerDAO();
		return passengerDAO.findByEmailAndPassword(email, password);
	}
	public Passenger findByEmail(String email) {
		PassengerDAO passengerDAO=new PassengerDAO();
		return passengerDAO.findByEmailAndReturn(email);
	}
	
}

