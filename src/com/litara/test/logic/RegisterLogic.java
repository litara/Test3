package com.litara.test.logic;

import com.litara.test.entities.Passenger;
import com.litara.test.service.PassengerService;

public class RegisterLogic {
	public static Passenger registrationLogin(Passenger passenger) {
		PassengerService passengerService=new PassengerService();
		if(checkEmail(passenger.getEmail())) {
			passengerService.create(passenger);
			return passenger;
		}
		return null;
	}
	public static boolean checkEmail(String email) {
		PassengerService passengerService=new PassengerService();
		if(passengerService.isExist(email)) {
			return false;
		}
		return true;
	}
}
