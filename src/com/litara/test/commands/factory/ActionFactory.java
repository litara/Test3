package com.litara.test.commands.factory;

import javax.servlet.http.HttpServletRequest;

import com.litara.test.commands.ActionCommand;
import com.litara.test.commands.EmptyCommand;
import com.litara.test.commands.client.CommandEnum;
import com.litara.test.resource.MessageManager;
import com.litara.test.servlet.requestContent.SessionRequestContent;

public class ActionFactory {
	public ActionCommand defineCommand(SessionRequestContent request) {
		ActionCommand current = new EmptyCommand();
		// извлечение имени команды из запроса
		String action = request.getParameter("command");
		if (action == null || action.isEmpty()) {
			// если команда не задана в текущем запросе
			return current;
		}
		// получение объекта, соответствующего команде
		try {
			CommandEnum currentEnum = CommandEnum.valueOf(action.toUpperCase());
			current = currentEnum.getCurrentCommand();
		} catch (IllegalArgumentException e) {
			request.setAttribute("wrongAction", action
					+ MessageManager.getProperty("message.wrongaction"));
		}
		return current;
	}
}
