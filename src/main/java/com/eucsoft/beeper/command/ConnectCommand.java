package com.eucsoft.beeper.command;

import com.eucsoft.beeper.model.Users;
import com.eucsoft.beeper.server.Responce;

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
