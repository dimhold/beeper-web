package com.eucsoft.beeper.command;

import com.eucsoft.beeper.server.Responce;
import com.eucsoft.beeper.user.User;

public class ConnectCommand implements Command {

	private User user;

	@Override
	public void setUser(User user) {
		this.user = user;
	}
	
	@Override
	public Responce process() {
		
	}

}
