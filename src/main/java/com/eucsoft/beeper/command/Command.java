package com.eucsoft.beeper.command;

import com.eucsoft.beeper.server.Responce;
import com.eucsoft.beeper.user.User;

public interface Command {
	
	public void setUser(User user);
	
	public Responce process();
	

}
