package com.eucsoft.beeper;

import com.eucsoft.beeper.command.Command;
import com.eucsoft.beeper.command.ConnectCommand;
import com.eucsoft.beeper.command.MessageCommand;
import com.eucsoft.beeper.model.User;
import com.eucsoft.beeper.server.Responce;

public class BeeperAPI {

	public Responce onConnect(User user) {
		Command command = new ConnectCommand();
		command.setUser(user);
		
		Responce responce = command.process();
		return responce;
	}

	public Responce onChangeRoom(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	public Responce onMessageStart(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	public Responce onMessage(User user, byte[] message) {
		Command command = new MessageCommand();
		command.setUser(user);
		
		Responce responce = command.process();
		return responce;
		/*for (Client client : server.connectedClients) {
			
		}*/
	}

	public Responce onMessageEnd(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	public Responce onDisconnect(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	public Responce sendMessage() {
		// TODO Auto-generated method stub
		return null;
	}

	public Responce sendCloseRoom() {
		// TODO Auto-generated method stub
		return null;
	}

	public Responce sendJoinToRoom() {
		// TODO Auto-generated method stub
		return null;
	}

}
