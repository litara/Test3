package com.litara.test.logic;

import com.litara.test.dao.PassengerDAO;
import com.litara.test.entities.Passenger;
import com.litara.test.service.PassengerService;

public class LoginLogic {
	public static Passenger checkLogin(String enterEmail, String enterPass) {
		PassengerService passengerService= new PassengerService();
		if(passengerService.isExist(enterEmail, enterPass)) {
			Passenger passenger = passengerService.findByEmail(enterEmail);
			return passenger;
		}
		return null;
	}
}
