package com.litara.test.commands;

import javax.servlet.http.HttpServletRequest;

import com.litara.test.logic.LoginLogic;
import com.litara.test.resource.ConfigurationManager;
import com.litara.test.resource.MessageManager;
import com.litara.test.servlet.requestContent.SessionRequestContent;

public class LoginCommand implements ActionCommand {
	private static final String PARAM_NAME_LOGIN = "login";
	private static final String PARAM_NAME_PASSWORD = "password";
	@Override
	public String execute(SessionRequestContent request) {
		String page = null;
		// извлечение из запроса логина и пароля
		String login = request.getParameter(PARAM_NAME_LOGIN);
		String pass = request.getParameter(PARAM_NAME_PASSWORD);
		// проверка логина и пароля
		if (LoginLogic.checkLogin(login, pass)) {
			request.setSessionAttribute("userLogin", login);
			// определение пути к main.jsp
			page = ConfigurationManager.getProperty("path.page.main");
		} else {
			request.setAttribute("errorLoginPassMessage",
					MessageManager.getProperty("message.loginerror"));
			page = ConfigurationManager.getProperty("path.page.login");
		}
		return page;
	}
}
