package com.litara.test.commands.admin;

import com.litara.test.commands.ActionCommand;
import com.litara.test.commands.client.CommandEnum;
import com.litara.test.commands.factory.EmptyCommand;
import com.litara.test.resource.MessageManager;
import com.litara.test.servlet.requestContent.SessionRequestContent;

public class AdminFactory {
	public ActionCommand defineCommand(SessionRequestContent request) {
		ActionCommand current = new EmptyCommand();
		// извлечение имени команды из запроса
		String action = request.getParameter("do");
		if (action == null || action.isEmpty()) {
			// если команда не задана в текущем запросе
			return current;
		}
		// получение объекта, соответствующего команде
		try {
			AdminCommandEnum currentEnum = AdminCommandEnum.valueOf(action.toUpperCase());
			current = currentEnum.getCurrentCommand();
		} catch (IllegalArgumentException e) {
			System.out.println(e.toString());
		}
		return current;
	}
}
