package com.eucsoft.beeper.client;

import java.io.PrintWriter;
import java.net.Socket;

import org.springframework.dao.CleanupFailureDataAccessException;
import org.testng.annotations.Test;

import com.eucsoft.beeper.config.Config;
import com.eucsoft.net.Client;

public class SendMessageTest {

	@Test
	public void write() {
		try {
			Socket clientSocket = new Socket("localhost", Config.getServerPort());
			Client client = new Client(clientSocket);
			Socket clientSocket2 = new Socket("localhost", Config.getServerPort());
			Client client2 = new Client(clientSocket2);
			//PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
			//while (true) {
				client.write("action: connect, id: 112233".getBytes(), false);
				//client2.write("{action:connect,id:445566}".getBytes());
			//}
			//out.close();
			//clientSocket.close();
				Thread.sleep(1000_0000);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
}
