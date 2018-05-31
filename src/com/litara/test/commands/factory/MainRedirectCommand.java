package com.litara.test.commands.factory;

import com.litara.test.commands.ActionCommand;
import com.litara.test.resource.ConfigurationManager;
import com.litara.test.servlet.requestContent.SessionRequestContent;

public class MainRedirectCommand implements ActionCommand{

	@Override
	public String execute(SessionRequestContent request) {
		String page=null;
		page=ConfigurationManager.getProperty("path.page.main");
		return page;
	}
	
}
