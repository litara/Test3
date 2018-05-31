package com.litara.test.commands.admin;

import com.litara.test.commands.ActionCommand;

public enum AdminCommandEnum {
	ADMINPANEL{
		{
			this.command = new AdminPanelRedirectCommand();
		}
	},
	PASSENGER{
		{
			this.command=new EditPassenger();
		}
	};
	ActionCommand command;
	public ActionCommand getCurrentCommand() {
		return command;
	}
}
