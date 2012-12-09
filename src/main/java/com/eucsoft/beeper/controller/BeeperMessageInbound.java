package com.eucsoft.beeper.controller;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

import org.apache.catalina.websocket.MessageInbound;
import org.apache.catalina.websocket.WsOutbound;

import com.eucsoft.beeper.model.Message;
import com.eucsoft.beeper.model.User;

public class BeeperMessageInbound extends MessageInbound {
	
	public static final Set<BeeperMessageInbound> connections = new CopyOnWriteArraySet<BeeperMessageInbound>();

	private User mUser;
	
	BeeperMessageInbound(User pUser) {
		mUser = pUser;
	}

	@Override
	protected void onOpen(WsOutbound outbound) {
		connections.add(this);
	}

	@Override
	protected void onClose(int status) {
		connections.remove(this);
	}

	@Override
	protected void onBinaryMessage(ByteBuffer message) throws IOException {
		
	}

	@Override
	protected void onTextMessage(CharBuffer message) throws IOException {
		
	}

	public static void broadcastAll(Message message) {
		for (BeeperMessageInbound connection : connections) {
			//if correct channel, but another user. TODO: optimize: loop only through the proper channel
			if (message.getChannel().equals(connection.mUser.getChannel()) && ! message.getUser().equals(connection.mUser)) {
				try {
					CharBuffer buffer = CharBuffer.wrap(message.getLocation());
					connection.getWsOutbound().writeTextMessage(buffer);
				} catch (IOException ignore) {
					// FIXME: Do not ignore
				}
			}
		}
	}

}
