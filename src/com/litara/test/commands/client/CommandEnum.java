package com.litara.test.commands.client;

import com.litara.test.commands.factory.ActionCommand;
import com.litara.test.commands.factory.LoginCommand;
import com.litara.test.commands.factory.LogoutCommand;
import com.litara.test.commands.factory.RegisterCommand;
import com.litara.test.commands.factory.RegisterRedirectCommand;

import net.bytebuddy.asm.Advice.This;

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
	};
	ActionCommand command;
	public ActionCommand getCurrentCommand() {
		return command;
	}
}
