package com.eucsoft.beeper.config;

import java.util.ResourceBundle;

public class ServerConfig {

	private static ResourceBundle config = ResourceBundle.getBundle("config");
	
	public static int getServerSocketTimeout() {
		String serverSocketTimeoutValue = config.getString("SERVER_SOCKET_TIMEOUT");
		int serverSocketTimeout = Integer.parseInt(serverSocketTimeoutValue);
		return serverSocketTimeout; 
	}
	
	public static int getClientReadTimeout() {
		String serverSocketTimeoutValue = config.getString("CLIENT_READ_TIMEOUT");
		int serverSocketTimeout = Integer.parseInt(serverSocketTimeoutValue);
		return serverSocketTimeout;
	}
}
