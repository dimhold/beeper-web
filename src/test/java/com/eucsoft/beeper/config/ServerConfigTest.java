package com.eucsoft.beeper.config;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ServerConfigTest {
	
	@Test
	public void serverSocketTimeout() {
		int expected = 100;
		int actual = Config.getServerSocketTimeout();
		Assert.assertEquals(actual, expected);
	}
	
	@Test
	public void clientReadTimeout() {
		int expected = 100;
		int actual = Config.getClientReadTimeout();
		Assert.assertEquals(actual, expected);
	}
	
	@Test
	public void serverPort() {
		int expected = 8069;
		int actual = Config.getServerPort();
		Assert.assertEquals(actual, expected);
	}

}
