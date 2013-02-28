package com.eucsoft.beeper.command;

import com.eucsoft.beeper.model.User;
import com.eucsoft.beeper.server.Responce;

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
