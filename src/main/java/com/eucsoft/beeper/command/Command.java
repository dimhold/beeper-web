package com.eucsoft.beeper.command;

import com.eucsoft.beeper.server.Responce;
import com.eucsoft.beeper.user.User;

public abstract class Command {
	
	private User user;

	public void setUser(User user) {
		this.user = user;
	}
	
	public User getUser() {
		return user;
	}
	
	public abstract Responce process();
	

}
