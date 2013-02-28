package com.eucsoft.beeper.client;

import java.net.Socket;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.eucsoft.beeper.config.Config;
import com.eucsoft.net.Client;
import com.eucsoft.net.Server;

public class ClientTest {

	@BeforeClass
	public void startServer() {
		System.out.println("starting");
		Server.start();
		System.out.println("started");
		
	}
	
	@Test
	public void read() throws Exception {
		System.out.println("run");
		Socket socket = new Socket("localhost", Config.getServerPort());
		Client client = new Client(socket);
		byte[] actual = client.read();
		Assert.assertEquals(actual, null);
	}

	@Test
	public void write() {
	}
	
	@AfterClass
	public void stopServer() {
		Server.stop();
	}
}
