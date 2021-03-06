package com.eucsoft.beeper.client;

import com.eucsoft.beeper.api.BeeperAPI;
import com.eucsoft.beeper.command.Command;
import com.eucsoft.beeper.command.ConnectCommand;
import com.eucsoft.beeper.command.MessageCommand;
import com.eucsoft.beeper.server.Responce;
import com.eucsoft.beeper.server.Server;
import com.eucsoft.beeper.user.User;

public class ClientHandler extends BeeperAPI {

	public ClientHandler(Client client, Server pServer) {
		super(client);
		server = pServer;
	}

	@Override
	public Responce onConnect(User user) {
		Command command = new ConnectCommand();
		command.setUser(user);
		
		Responce responce = command.process();
		return responce;
	}

	@Override
	public Responce onChangeRoom(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Responce onMessageStart(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Responce onMessage(User user, byte[] message) {
		Command command = new MessageCommand();
		command.setUser(user);
		
		Responce responce = command.process();
		return responce;
		/*for (Client client : server.connectedClients) {
			
		}*/
	}

	@Override
	public Responce onMessageEnd(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Responce onDisconnect(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Responce sendMessage() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Responce sendCloseRoom() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Responce sendJoinToRoom() {
		// TODO Auto-generated method stub
		return null;
	}

}
