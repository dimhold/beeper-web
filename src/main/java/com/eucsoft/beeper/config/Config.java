package com.eucsoft.beeper.config;

import java.util.ResourceBundle;

public class Config {

	private static final String CONFIG_FILE = "com.eucsoft.beeper.config.config";
	private static final ResourceBundle config = ResourceBundle.getBundle(CONFIG_FILE);

	private static final int read(String key) {
		int value = Integer.parseInt( config.getString(key) );
		return value;
	}
	
	public static int getServerPort() {
		int serverPort = read("SERVER_PORT");
		return serverPort;
	}
	public static int getServerSocketTimeout() {
		int serverSocketTimeoutValue = read("SERVER_SOCKET_TIMEOUT");
		return serverSocketTimeoutValue;
	}
	
	public static int getClientReadTimeout() {
		int serverSocketTimeout = read("CLIENT_READ_TIMEOUT");
		return serverSocketTimeout;
	}
	
	public static int getBufferReadSize() {
		int bufferReadSize = read("BUFFER_READ_SIZE");
		return bufferReadSize;
	}
}
