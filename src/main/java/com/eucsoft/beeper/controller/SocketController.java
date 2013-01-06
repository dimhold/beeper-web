package com.eucsoft.beeper.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.Channel;
import java.nio.channels.FileChannel;
import java.util.Random;

import com.eucsoft.beeper.BeeberAPI;

public class SocketController implements BeeberAPI, Runnable {

	private Socket client;
	
	private InputStream input;
	private OutputStream out;

	public SocketController(Socket socket) {
		this.client = socket;
	}
	
	private void init() throws IOException {
		input = client.getInputStream();
		out = client.getOutputStream();
	}

	@Override
	public void run() {
		try {
			init();
			responce();
			read();
			//close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void read() {
		try {
			Random r = new Random();
			String uid = Integer.toString(r.nextInt(5000));
			FileOutputStream file = new FileOutputStream(new File("audio" + uid));
			byte[] buffer = new byte[1024];
			int messageSize = 0;
			

			while (messageSize != -1) {
				messageSize = input.read(buffer);
				if (messageSize > 0) {
					file.write(buffer, 0, messageSize);
					file.flush();
					System.out.println("get: " + messageSize);
				}
			}
			//String clientLine = input.readLine();
			//System.out.println("<- CLIENT: " + new String(buffer));
			file.close();
			System.out.println("File closed");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void responce() throws IOException {
		out.write("Hi, I'm serever\n".getBytes());
		out.flush();
		System.out.println("send client ->");
	}
	
	private void close() throws IOException {
		System.out.println("Don't close socket");
		client.close();
	}

}
