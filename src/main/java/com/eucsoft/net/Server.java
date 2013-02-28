package com.eucsoft.net;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.eucsoft.beeper.config.Config;
import com.eucsoft.beeper.net.ClientHandler;

public class Server {

	private static boolean isServerRunning = false;
	
	private int port;
	private ServerSocket serverSocket;
	
	public static void start() {
		isServerRunning = true;

		Server server = new Server(Config.getServerPort());
		server.init();
		server.waitClient();
		server.close();
	}
	
	public static void stop() {
		isServerRunning = false;
	}

	
	
	public Server(int port) {
		this.port = port;
	}
	
	private void init() {
		try {
			serverSocket = new ServerSocket(port);
			serverSocket.setSoTimeout( Config.getServerSocketTimeout() );
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void waitClient() {
		while(isServerRunning) {
			try {
				Socket socket = serverSocket.accept();
				processClient(socket);
			} catch (SocketTimeoutException e) {
				//ignore timeout.
			} catch (SocketException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	private void processClient(Socket socket) throws IOException {
		Client client = new Client(socket);
		ClientHandler handler = new ClientHandler(client);

		ExecutorService executor = Executors.newSingleThreadExecutor();
		executor.execute(handler);
	}

	private void close() {
		try {
			serverSocket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
