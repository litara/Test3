package com.litara.test.commands.admin;

import com.litara.test.commands.ActionCommand;
import com.litara.test.entities.Passenger;
import com.litara.test.resource.ConfigurationManager;
import com.litara.test.service.PassengerService;
import com.litara.test.servlet.requestContent.SessionRequestContent;

public class DoUpdatePassenger implements ActionCommand{
	private static String PARAM_NAME_EMAIL="email";
	private static String PARAM_NAME_PASS="password";
	private static String PARAM_NAME_NAME="name";
	private static String PARAM_NAME_ROLE="role";
	private static String PARAM_NAME_ID="id";
	@Override
	public String execute(SessionRequestContent request) {
		String page = null;
		Passenger passenger = new Passenger();
		passenger.setEmail(request.getParameter(PARAM_NAME_EMAIL));
		passenger.setPassword(request.getParameter(PARAM_NAME_PASS));
		passenger.setName(request.getParameter(PARAM_NAME_NAME));
		passenger.setRole(request.getParameter(PARAM_NAME_ROLE));
		passenger.setId(Integer.parseInt(request.getParameter(PARAM_NAME_ID)));
		PassengerService passengerService = new PassengerService();
		passengerService.update(passenger);
		page=ConfigurationManager.getProperty("path.page.adminpanel");
		return page;
	}
	

}
