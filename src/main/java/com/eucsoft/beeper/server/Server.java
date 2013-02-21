package com.eucsoft.beeper.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.eucsoft.beeper.client.Client;
import com.eucsoft.beeper.client.ClientForViktor;
import com.eucsoft.beeper.client.ClientHandler;
import com.eucsoft.beeper.config.ServerConfig;

public class Server {

	private static boolean isServerRunning = false;
	
	private int port;
	private ServerSocket serverSocket;
	public List<Client> connectedClients = new ArrayList<Client>();
	
	public static void start() {
		isServerRunning = true;

		Server server = new Server(ServerConfig.getServerPort());
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
			serverSocket.setSoTimeout( ServerConfig.getServerSocketTimeout() );
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
		Client client = new ClientForViktor(socket);
		ClientHandler handler = new ClientHandler(client, this);

		ExecutorService executor = Executors.newSingleThreadExecutor();
		executor.execute(handler);
		
		connectedClients.add(client);
	}

	private void close() {
		try {
			serverSocket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
