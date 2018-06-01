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
	},
	DEL{
		{
			this.command=new DeletePassenger();
		}
	},
	CREATE{
		{
			this.command=new CreatePassenger();
		}
	},
	UPDATE{
		{
			this.command=new UpdatePassenger();
		}
	},
	DOUPDATE{
		{
			this.command=new DoUpdatePassenger();
		}
	};
	ActionCommand command;
	public ActionCommand getCurrentCommand() {
		return command;
	}
}
