package com.eucsoft.beeper.api;

import com.eucsoft.beeper.server.Responce;
import com.eucsoft.beeper.user.User;

public interface ServerAPI {
	
	public Responce onConnect(User user);
	
	public Responce onChangeRoom(User user);
	
	public Responce onMessageStart(User user);
	
	public Responce onMessage(User user, byte[] message);
	
	public Responce onMessageEnd(User user);
	
	public Responce onDisconnect(User user);
	
	public Responce sendMessage();
	
	public Responce sendCloseRoom();
	
	public Responce sendJoinToRoom();

}
