package com.litara.test.commands.client;

import com.litara.test.commands.ActionCommand;
import com.litara.test.resource.ConfigurationManager;
import com.litara.test.servlet.requestContent.SessionRequestContent;

public class RegisterRedirectCommand implements ActionCommand{

	@Override
	public String execute(SessionRequestContent request) {
		String page=null;
		page=ConfigurationManager.getProperty("path.page.register");
		return page;
	}
}
