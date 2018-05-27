package com.litara.test.commands.factory;

import javax.servlet.http.HttpServletRequest;

import com.litara.test.servlet.requestContent.SessionRequestContent;

public interface ActionCommand {
	String execute(SessionRequestContent request);
}
