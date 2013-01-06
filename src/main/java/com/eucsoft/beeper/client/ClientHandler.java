package com.eucsoft.beeper.client;

import com.eucsoft.beeper.api.BeeperAPI;
import com.eucsoft.beeper.server.Responce;
import com.eucsoft.beeper.user.User;

public class ClientHandler extends BeeperAPI {

	public ClientHandler(Client client) {
		super(client);
	}

	@Override
	public Responce onConnect(User user) {
		// TODO Auto-generated method stub
		return null;
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
		// TODO Auto-generated method stub
		return null;
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
