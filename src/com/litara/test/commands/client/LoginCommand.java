package com.litara.test.commands.client;

import javax.servlet.http.HttpServletRequest;

import com.litara.test.commands.ActionCommand;
import com.litara.test.entities.Passenger;
import com.litara.test.logic.LoginLogic;
import com.litara.test.resource.ConfigurationManager;
import com.litara.test.resource.MessageManager;
import com.litara.test.servlet.requestContent.SessionRequestContent;

public class LoginCommand implements ActionCommand {
	private static final String PARAM_NAME_EMAIL = "email";
	private static final String PARAM_NAME_PASSWORD = "password";
	@Override
	public String execute(SessionRequestContent request) {
		String page = null;
		// извлечение из запроса логина и пароля
		String email = request.getParameter(PARAM_NAME_EMAIL).toString();
		String pass = request.getParameter(PARAM_NAME_PASSWORD).toString();
		// проверка логина и пароля
		Passenger passenger = LoginLogic.checkLogin(email, pass);
		if (passenger!=null) {
			request.setSessionAttribute("passenger", passenger );
			// определение пути к main.jsp
			page = ConfigurationManager.getProperty("path.page.main");
		} else {
			request.setAttribute("errorMessage", MessageManager.getProperty("message.loginerror"));
			page = ConfigurationManager.getProperty("path.page.main");
		}
		return page;
	}
}
