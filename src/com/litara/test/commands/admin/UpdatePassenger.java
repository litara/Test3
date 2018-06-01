package com.litara.test.commands.admin;

import java.util.List;

import com.litara.test.commands.ActionCommand;
import com.litara.test.entities.Passenger;
import com.litara.test.resource.ConfigurationManager;
import com.litara.test.service.PassengerService;
import com.litara.test.servlet.requestContent.SessionRequestContent;

public class UpdatePassenger implements ActionCommand{
	private static String PARAM_NAME_EMAIL="email";
	private static String PARAM_NAME_PASS="password";
	private static String PARAM_NAME_NAME="name";
	private static String PARAM_NAME_ROLE="role";
	private static String PARAM_NAME_ID="id";
	@Override
	public String execute(SessionRequestContent request) {
		String page=null;
		request.setAttribute("update", true);
		request.setAttribute("editPassenger", true);
		String email=request.getParameter(PARAM_NAME_EMAIL);
		String password=request.getParameter(PARAM_NAME_PASS);
		String name=request.getParameter(PARAM_NAME_NAME);
		String role=request.getParameter(PARAM_NAME_ROLE);
		int id=Integer.parseInt(request.getParameter(PARAM_NAME_ID));
		request.setAttribute("email", email);
		request.setAttribute("password", password);
		request.setAttribute("name", name);
		request.setAttribute("role", role);
		request.setAttribute("id", id);
		PassengerService passengerService=new PassengerService();
		List<Passenger> list=passengerService.outputAll();
		request.setAttribute("tablePassengers", list);
		page=ConfigurationManager.getProperty("path.page.adminpanel");
		return page;
	}
	

}
