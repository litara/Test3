package com.litara.test.service;

import com.litara.test.dao.PassengerDAO;
import com.litara.test.entities.Passanger;

public class PassangerService extends AbstractService<Passanger> {

	@Override
	public void create(Passanger entity) {
		PassengerDAO passengerDAO = new PassengerDAO();
		passengerDAO.create(entity);
		
	}

	@Override
	public Passanger findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Passanger entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Passanger entity) {
		// TODO Auto-generated method stub
		
	}
	
}

