package com.litara.test.commands.client;

import com.litara.test.commands.factory.ActionCommand;
import com.litara.test.commands.factory.LoginCommand;
import com.litara.test.commands.factory.LogoutCommand;

public enum CommandEnum {
	LOGIN {
		{
			this.command = new LoginCommand();
		}
	},
	LOGOUT {
		{
			this.command = new LogoutCommand();
		}
	};
	ActionCommand command;
	public ActionCommand getCurrentCommand() {
		return command;
	}
}
