package com.litara.test.commands.client;

import com.litara.test.commands.ActionCommand;
import com.litara.test.commands.LoginCommand;
import com.litara.test.commands.LoginRegirect;
import com.litara.test.commands.LogoutCommand;

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
	},
	LOGINREDIRECT{
		{
			this.command=new LoginRegirect();
		}
	};
	ActionCommand command;
	public ActionCommand getCurrentCommand() {
		return command;
	}
}
