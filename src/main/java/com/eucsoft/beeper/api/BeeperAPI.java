package com.eucsoft.beeper.api;

import com.eucsoft.beeper.client.Client;
import com.eucsoft.beeper.server.Request;
import com.eucsoft.beeper.server.Responce;
import com.eucsoft.beeper.user.User;
import com.eucsoft.beeper.util.RequstUtil;
import com.eucsoft.beeper.util.ResponceUtil;

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
			Request requset = RequstUtil.getRequst(requestBytes);
			generateEvent(requset);
		}
	}
	
	private void generateEvent(Request requst) {
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
		ResponceUtil reader = new ResponceUtil(responce);
		byte[] responceBytes = reader.toBytes();
		client.write(responceBytes);
	}
	
	private void sendToClient(Request request) {
		byte[] requsetBytes = RequstUtil.toBytes(request);
		client.write(requsetBytes);
	}
	

}
