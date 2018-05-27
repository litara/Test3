package com.litara.test.logic;

import com.litara.test.dao.PassengerDAO;
import com.litara.test.entities.Passanger;
import com.litara.test.service.PassangerService;

public class LoginLogic {
	private final static String ADMIN_LOGIN = "admin";
	private final static String ADMIN_PASS = "Qwe123";
	public static boolean checkLogin(String enterLogin, String enterPass) {
		Passanger pass=new Passanger();
		pass.setEmail(enterLogin);
		pass.setPassword(enterPass);
		pass.setRole("ADMIN");
		PassangerService service = new PassangerService();
		service.create(pass);
		return ADMIN_LOGIN.equals(enterLogin) && ADMIN_PASS.equals(enterPass);
	}
}
