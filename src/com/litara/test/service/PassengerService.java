package com.litara.test.service;

import java.util.List;

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
		PassengerDAO passengerDAO = new PassengerDAO();
		Passenger passenger = passengerDAO.findById(id);
		return passenger;
	}

	@Override
	public void update(Passenger entity) {
		PassengerDAO passengerDAO = new PassengerDAO();
		passengerDAO.update(entity);
	}

	@Override
	public void delete(Passenger entity) {
		PassengerDAO passengerDAO=new PassengerDAO();
		passengerDAO.delete(entity);
		
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
	public List<Passenger> outputAll(){
		PassengerDAO passengerDAO=new PassengerDAO();
		return passengerDAO.output();
	}
	
}

