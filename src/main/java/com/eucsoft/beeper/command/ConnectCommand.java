package com.eucsoft.beeper.command;

import com.eucsoft.beeper.server.Responce;
import com.eucsoft.beeper.user.Users;

public class ConnectCommand extends Command {

	@Override
	public Responce process() {
		Users.add(getUser());
		
		Responce responce = new Responce();
		responce.setAction("connect");
		responce.setStatus("200");
		
		return responce;
	}

}
