package com.litara.test.logic;

import com.litara.test.dao.PassengerDAO;
import com.litara.test.entities.Passenger;
import com.litara.test.service.PassengerService;

public class LoginLogic {
	private final static String ADMIN_LOGIN = "admin";
	private final static String ADMIN_PASS = "Qwe123";
	public static boolean checkLogin(String enterLogin, String enterPass) {
		Passenger pass=new Passenger();
		pass.setEmail(enterLogin);
		pass.setPassword(enterPass);
		pass.setRole("ADMIN");
		PassengerService service = new PassengerService();
		service.create(pass);
		return ADMIN_LOGIN.equals(enterLogin) && ADMIN_PASS.equals(enterPass);
	}
}
