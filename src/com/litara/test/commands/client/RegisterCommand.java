package com.litara.test.commands.client;

import com.litara.test.commands.ActionCommand;
import com.litara.test.entities.Passenger;
import com.litara.test.logic.LoginLogic;
import com.litara.test.logic.RegisterLogic;
import com.litara.test.resource.ConfigurationManager;
import com.litara.test.servlet.requestContent.SessionRequestContent;

public class RegisterCommand implements ActionCommand{
	private static final String PARAM_NAME_ROLE="PASSENGER";
	private static final String PARAM_NAME_EMAIL="email";
	private static final String PARAM_NAME_PASSWORD="password";
	private static final String PARAM_NAME_NAME="name";
	private static final String PARAM_NAME_SURNAME="surname";
	private static final String PARAM_NAME_MIDDLE_NAME="middle_name";
	private static final String PARAM_NAME_CONFIRM_PASSWORD="password-confirm";
	@Override
	public String execute(SessionRequestContent request) {
		String page=null;
		String email=request.getParameter(PARAM_NAME_EMAIL);
		String pass=request.getParameter(PARAM_NAME_PASSWORD);
		String name=request.getParameter(PARAM_NAME_NAME);
		String surname=request.getParameter(PARAM_NAME_SURNAME);
		String middleName=request.getParameter(PARAM_NAME_MIDDLE_NAME);
		String passwordConfirm=request.getParameter(PARAM_NAME_CONFIRM_PASSWORD);
		Passenger passenger=new Passenger();
		passenger.setEmail(email);
		passenger.setPassword(pass);
		passenger.setRole(PARAM_NAME_ROLE);
		passenger.setName(name);
		passenger.setMiddle_name(middleName);
		passenger.setSurname(surname);
		if(!passwordConfirm.equals(pass)) {
			page=ConfigurationManager.getProperty("path.page.register");
			request.setAttribute("errorMessage", "Пароли не соответстуют");
			return page;
		}
		if(!RegisterLogic.checkEmail(email)) {
			request.setAttribute("errorMessage","Такой пользователь уже существует");
			page=ConfigurationManager.getProperty("path.page.register");
			return page;
		}
		if(RegisterLogic.registrationLogin(passenger)!=null) {
			request.setSessionAttribute("passenger", passenger);
			page=ConfigurationManager.getProperty("path.page.main");
		}else {
			request.setAttribute("errorMessages", "Some errors with registration");
			page=ConfigurationManager.getProperty("path.page.main");
		}
		return page;
	}
	
}
