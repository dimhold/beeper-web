package com.eucsoft.beeper.client;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketTimeoutException;

import org.apache.commons.io.output.ByteArrayOutputStream;

import com.eucsoft.beeper.config.ServerConfig;

public class ClientForViktor extends Client {

	private Socket socket;
	private InputStream input;
	
	public ClientForViktor(Socket socket) throws IOException {
		super(socket);
		this.socket = socket;
		input = socket.getInputStream();
	}
	
	@Override
	public byte[] read() {
		try {
			socket.setSoTimeout(ServerConfig.getClientReadTimeout());
			byte[] buffer = new byte[ ServerConfig.getBufferReadSize() ];
			ByteArrayOutputStream requset = new ByteArrayOutputStream();
			int messageSize = 0;
			
			messageSize = input.read(buffer);
			requset.write(buffer, 0, messageSize);
			
			return requset.toByteArray();
			
		} catch (SocketTimeoutException e) {
			//ignore timeout.
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
