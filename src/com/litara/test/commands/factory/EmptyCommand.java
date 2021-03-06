package com.litara.test.commands.factory;

import javax.servlet.http.HttpServletRequest;

import com.litara.test.commands.ActionCommand;
import com.litara.test.resource.ConfigurationManager;
import com.litara.test.servlet.requestContent.SessionRequestContent;

public class EmptyCommand implements ActionCommand {
	@Override
	public String execute(SessionRequestContent request) {
		String page = ConfigurationManager.getProperty("path.page.login");
		return page;
	}
}
