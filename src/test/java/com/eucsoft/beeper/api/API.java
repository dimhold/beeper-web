package com.eucsoft.beeper.api;

import java.io.IOException;
import java.net.Socket;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.eucsoft.beeper.client.Client;
import com.eucsoft.beeper.config.ServerConfig;

//Server should be runned in the background. It is not a unit test, but integration test!
public class API {
	
	private Client client;
	
	@BeforeClass
	public void init() throws IOException {
		Socket socket = new Socket("localhost", ServerConfig.getServerPort());
		client = new Client(socket);
	}

	@Test
	public void connect() {
		String expected = "action: connect, status: 200";
		
		client.write("id: 12312312312, action: connect, info: android 4.2".getBytes());
		String actual = new String(client.read());
		
		Assert.assertEquals(actual, expected);
	}
	
}
