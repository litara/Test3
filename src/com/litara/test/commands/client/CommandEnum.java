package com.litara.test.commands.client;

import com.litara.test.commands.ActionCommand;
import com.litara.test.commands.factory.MainRedirectCommand;

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
	REGISTERREDIRECT{
		{
			this.command=new RegisterRedirectCommand();
		}
	},
	REGISTER{
		{
			this.command=new RegisterCommand();
		}
	},
	MAIN{
		{
			this.command=new MainRedirectCommand();
		}
	};
	ActionCommand command;
	public ActionCommand getCurrentCommand() {
		return command;
	}
}
