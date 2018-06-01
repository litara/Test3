package com.litara.test.commands.admin;

import java.util.List;

import com.litara.test.commands.ActionCommand;
import com.litara.test.entities.Passenger;
import com.litara.test.resource.ConfigurationManager;
import com.litara.test.service.PassengerService;
import com.litara.test.servlet.requestContent.SessionRequestContent;

public class CreatePassenger implements ActionCommand{
	private static String PARAM_NAME_EMAIL="email";
	private static String PARAM_NAME_PASS="password";
	private static String PARAM_NAME_NAME="name";
	private static String PARAM_NAME_ROLE="role";
	@Override
	public String execute(SessionRequestContent request) {
		String page=null;
		String name=request.getParameter(PARAM_NAME_NAME);
		String email=request.getParameter(PARAM_NAME_EMAIL);
		String pass=request.getParameter(PARAM_NAME_PASS);
		String role=request.getParameter(PARAM_NAME_ROLE);
		Passenger passenger=new Passenger();
		passenger.setEmail(email);
		passenger.setPassword(pass);
		passenger.setName(name);
		passenger.setRole(role);
		PassengerService passengerService= new PassengerService();
		passengerService.create(passenger);
		List<Passenger> list=passengerService.outputAll();
		request.setAttribute("tablePassengers", list);
		request.setAttribute("editPassenger", true);
		page=ConfigurationManager.getProperty("path.page.adminpanel");
		return page;
	}
	
}
