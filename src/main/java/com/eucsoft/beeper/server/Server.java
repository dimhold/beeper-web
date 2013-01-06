package com.eucsoft.beeper.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.eucsoft.beeper.client.Client;
import com.eucsoft.beeper.client.ClientHandler;
import com.eucsoft.beeper.config.ServerConfig;

public class Server {
	
	private static boolean isServerRunning = false;
	
	public static void start() {
		isServerRunning = true;

		init();
	}
	
	public static void stop() {
		isServerRunning = false;
	}
	
	private static void init() {
		try {
			ServerSocket serverSocket = new ServerSocket( ServerConfig.getServerPort() );
			serverSocket.setSoTimeout( ServerConfig.getServerSocketTimeout() );
			waitClient(serverSocket);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static void waitClient(ServerSocket serverSocket) throws IOException {
		while(isServerRunning) {
			try {
				Socket socket = serverSocket.accept();
				processClient(socket);
			} catch (SocketTimeoutException e) {
				//ignore timeout.
			} catch (SocketException e) {
				e.printStackTrace();
			}
		}
	}
	
	private static void processClient(Socket socket) throws IOException {
		Client client = new Client(socket);
		ClientHandler handler = new ClientHandler(client);

		ExecutorService executor = Executors.newSingleThreadExecutor();
		executor.execute(handler);
	}

}
