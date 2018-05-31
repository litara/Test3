package com.litara.test.logic;

import java.util.List;

import com.litara.test.entities.Passenger;
import com.litara.test.service.PassengerService;

public class AdminPanelLogic {
	public static List<Passenger> editPassengers(){
		PassengerService passengerService = new PassengerService();
		List<Passenger> result = passengerService.outputAll();
		return result;
	}
}
