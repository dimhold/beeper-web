package com.eucsoft.net;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketTimeoutException;

import org.apache.commons.io.output.ByteArrayOutputStream;

import com.eucsoft.beeper.config.Config;

public class Client {

	private Socket socket;
	private InputStream input;
	private OutputStream output;
	private FileOutputStream fos;
	
	public Client(Socket socket) throws IOException {
		File file = new File("D:/temp/test.wav");
		fos = new FileOutputStream(file, true);
		this.socket = socket;
		input = socket.getInputStream();
		output = socket.getOutputStream();
	}
	
	public byte[] read() {
		try {
			socket.setSoTimeout(Config.getClientReadTimeout());
			byte[] buffer = new byte[ Config.getBufferReadSize() ];
			ByteArrayOutputStream requset = new ByteArrayOutputStream();
			int messageSize = 0;
			
			while (true) {
				messageSize = input.read(buffer);
				
				if (messageSize == -1) {
					break;
				}
				requset.write(buffer, 0, messageSize);
			}
			
			if (requset.size() > 0) {
				System.out.println("Server receive: " + new String(requset.toByteArray()));
				return requset.toByteArray();
			} else {
				return null;
			}
			
		} catch (SocketTimeoutException e) {
			//ignore timeout.
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public void write(byte[] request, boolean saveToFile) {
		try {
			System.out.println("Server send: " + new String(request));
			output.write(request);
			if (saveToFile) {
				fos.write(request);
				fos.flush();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
