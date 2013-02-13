package com.eucsoft.beeper.client;

import java.io.PrintWriter;
import java.net.Socket;

import org.springframework.dao.CleanupFailureDataAccessException;
import org.testng.annotations.Test;

import com.eucsoft.beeper.config.ServerConfig;

public class SendMessageTest {

	@Test
	public void write() {
		try {
			Socket clientSocket = new Socket("localhost", ServerConfig.getServerPort());
			Client client = new Client(clientSocket);
			Socket clientSocket2 = new Socket("localhost", ServerConfig.getServerPort());
			Client client2 = new Client(clientSocket2);
			//PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
			//while (true) {
				client.write("onMessageStart".getBytes());
				client.write("blahblahblah".getBytes());
			//}
			//out.close();
			//clientSocket.close();
				Thread.sleep(1000_0000);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
}
