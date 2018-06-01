package com.litara.test.commands.admin;

import java.util.List;

import com.litara.test.commands.ActionCommand;
import com.litara.test.entities.Passenger;
import com.litara.test.resource.ConfigurationManager;
import com.litara.test.service.PassengerService;
import com.litara.test.servlet.requestContent.SessionRequestContent;

public class DeletePassenger implements ActionCommand{
	private static String PARAM_NAME_ID="id";
	@Override
	public String execute(SessionRequestContent request) {
		String page=null;
		int id=Integer.parseInt(request.getParameter(PARAM_NAME_ID));
		System.out.println(id);
		PassengerService passengerService = new PassengerService();
		Passenger passenger = passengerService.findById(id);
		passengerService.delete(passenger);
		request.setAttribute("editPassenger", true);
		page = ConfigurationManager.getProperty("path.page.adminpanel");
		List<Passenger> list = passengerService.outputAll();
		request.setAttribute("tablePassengers", list);
		return page;
	}
	
}
