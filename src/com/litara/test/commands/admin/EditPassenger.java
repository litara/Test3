package com.litara.test.commands.admin;

import java.util.List;

import com.litara.test.commands.ActionCommand;
import com.litara.test.entities.Passenger;
import com.litara.test.logic.AdminPanelLogic;
import com.litara.test.resource.ConfigurationManager;
import com.litara.test.servlet.requestContent.SessionRequestContent;

public class EditPassenger implements ActionCommand{

	@Override
	public String execute(SessionRequestContent request) {
		String page=null;
		List<Passenger> passengers = AdminPanelLogic.editPassengers();
		request.setAttribute("editTrains", false);
		request.setAttribute("editPassenger", true);
		request.setAttribute("tablePassengers", passengers);
		page=ConfigurationManager.getProperty("path.page.adminpanel");
		return page;
	}
	

}
