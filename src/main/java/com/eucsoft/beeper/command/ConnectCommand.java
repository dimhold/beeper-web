package com.eucsoft.beeper.command;

import com.eucsoft.beeper.server.Responce;
import com.eucsoft.beeper.user.User;
import com.eucsoft.beeper.user.Users;

public class ConnectCommand implements Command {

	private User user;

	@Override
	public void setUser(User user) {
		this.user = user;
	}
	
	@Override
	public Responce process() {
		Users.add(user);
		
		Responce responce = new Responce();
		responce.setAction("connect");
		responce.setStatus("200");
		
		return responce;
	}

}
