package com.litara.test.commands.factory;

import com.litara.test.resource.ConfigurationManager;
import com.litara.test.servlet.requestContent.SessionRequestContent;

/**
 * @author Андрей
 *
 */
public class LoginRegirect implements ActionCommand{

	@Override
	public String execute(SessionRequestContent request) {
		String page = ConfigurationManager.getProperty("path.page.login");
		return page;
	}
	
}
