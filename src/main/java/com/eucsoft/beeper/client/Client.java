package com.eucsoft.beeper.client;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketTimeoutException;

import org.apache.commons.io.output.ByteArrayOutputStream;

import com.eucsoft.beeper.config.ServerConfig;

public class Client {

	private Socket socket;
	private InputStream input;
	private OutputStream output;
	
	public Client(Socket socket) throws IOException {
		this.socket = socket;
		input = socket.getInputStream();
		output = socket.getOutputStream();
	}
	
	public byte[] read() {
		try {
			socket.setSoTimeout(ServerConfig.getClientReadTimeout());
			byte[] buffer = new byte[ ServerConfig.getBufferReadSize() ];
			ByteArrayOutputStream requset = new ByteArrayOutputStream();
			int messageSize = 0;
			
			while (messageSize != -1) {
				messageSize = input.read(buffer);
				requset.write(buffer, 0, messageSize);
			}
			return requset.toByteArray();
			
		} catch (SocketTimeoutException e) {
			e.printStackTrace();
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public void write(byte[] request) {
		try {
			output.write(request);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
