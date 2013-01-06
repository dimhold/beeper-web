package com.eucsoft.beeper.config;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ServerConfigTest {
	
	@Test
	public void serverSocketTimeout() {
		int expected = 100;
		int actual = ServerConfig.getServerSocketTimeout();
		Assert.assertEquals(actual, expected);
	}
	
	@Test
	public void clientReadTimeout() {
		int expected = 100;
		int actual = ServerConfig.getClientReadTimeout();
		Assert.assertEquals(actual, expected);
	}

}
