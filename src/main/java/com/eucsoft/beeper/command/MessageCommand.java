package com.eucsoft.beeper.command;

import com.eucsoft.beeper.server.Responce;

public class MessageCommand extends Command {

	@Override
	public Responce process() {
		Responce responce = new Responce();
		responce.setAction("message");
		responce.setStatus("200");
		
		return responce;
	}

}
