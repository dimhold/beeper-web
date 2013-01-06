package com.eucsoft.beeper.api;

import com.eucsoft.beeper.client.Client;
import com.eucsoft.beeper.server.Requset;
import com.eucsoft.beeper.server.Responce;
import com.eucsoft.beeper.user.User;
import com.eucsoft.beeper.util.RequstReader;
import com.eucsoft.beeper.util.ResponceReader;

public abstract class BeeperAPI implements Runnable, ServerAPI {
	
	private Client client;
	
	public BeeperAPI(Client client) {
		this.client = client;
	}

	@Override
	public void run() {
		listenClient();
	}
	
	private void listenClient() {
		while(true) {
			byte[] requestBytes = client.read();
			RequstReader reader = new RequstReader(requestBytes);
			Requset requset = reader.getRequst();
			
			generateEvent(requset);
		}
	}
	
	private void generateEvent(Requset requst) {
		User user = requst.getUser();
		String action = requst.getAction();
		switch (action) {
		case "connect":
			onConnect(user);
			break;
		case "disconnect":
			onDisconnect(user);
			break;
		case "changeRoom":
			onChangeRoom(user);
			break;
		case "messageStart":
			onMessageStart(user);
			break;
		case "messageEnd":
			onMessageEnd(user);
			break;
		case "message":
			byte[] message = null;
			onMessage(user, message);
			break;
		default:
			break;
		}
		
	}
	
	private void sendToClient(Responce responce) {
		ResponceReader reader = new ResponceReader(responce);
		byte[] responceBytes = reader.toBytes();
		client.write(responceBytes);
	}
	
	private void sendToClient(Requset requset) {
		RequstReader reader = new RequstReader(requset);
		byte[] requsetBytes = reader.toBytes();
		client.write(requsetBytes);
	}
	

}
