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

			if (requestBytes == null) {
				return;
			}

			Request request = RequstUtil.getRequst(requestBytes);
			Responce responce = processClient(request);
			sendToClient(responce);
		}
	}
	
	private Responce processClient(Request request) {
		User user = request.getUser();
		String action = request.getAction();
		
		switch (action) {
		case "connect":
			return onConnect(user);
		case "disconnect":
			return onDisconnect(user);
		case "changeRoom":
			return onChangeRoom(user);
		case "messageStart":
			return onMessageStart(user);
		case "messageEnd":
			return onMessageEnd(user);
		case "message":
			byte[] message = null;
			return onMessage(user, message);
		}
		
		Responce errorResponce = new Responce();
		errorResponce.setStatus("400");
		return errorResponce;
	}
	
	private void sendToClient(Responce responce) {
		if (responce == null) {
			return;
		}
		byte[] responceBytes = ResponceUtil.toBytes(responce);
		client.write(responceBytes);
	}
	
	private void sendToClient(Request request) {
		byte[] requsetBytes = RequstUtil.toBytes(request);
		client.write(requsetBytes);
	}
	

}
