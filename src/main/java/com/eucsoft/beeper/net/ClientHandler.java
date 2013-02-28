package com.eucsoft.beeper.net;

import com.eucsoft.beeper.BeeperAPI;
import com.eucsoft.beeper.model.User;
import com.eucsoft.beeper.server.Request;
import com.eucsoft.beeper.server.Responce;
import com.eucsoft.beeper.util.RequstUtil;
import com.eucsoft.beeper.util.ResponceUtil;
import com.eucsoft.net.Client;

public class ClientHandler implements Runnable {
	
	private Client client;
	private BeeperAPI beeperAPI = new BeeperAPI();
	
	public ClientHandler(Client client) {
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
			
			System.out.println(request.getAction());
		}
	}
	
	private Responce processRequest(Request request) {
		User user = request.getUser();
		String action = request.getAction();
//		User user = Beeper.getUser(requrest.id, client)
		
		
		switch (action) {
		case "connect":
			return beeperAPI.onConnect(user);
		case "disconnect":
			return beeperAPI.onDisconnect(user);
		case "changeRoom":
			return beeperAPI.onChangeRoom(user);
		case "messageStart":
			return beeperAPI.onMessageStart(user);
		case "messageEnd":
			return beeperAPI.onMessageEnd(user);
		case "message":
			byte[] message = (byte[]) request.getParam("message");
			return beeperAPI.onMessage(user, message);
		}
		
		Responce errorResponce = new Responce();
		errorResponce.setStatus("400");
		return errorResponce;
	}
	
	private void sendResponseToClient(Responce responce) {
		if (responce == null) {
			return;
		}
		byte[] responceBytes = ResponceUtil.toBytes(responce);
		client.write(responceBytes, false);
	}

}
