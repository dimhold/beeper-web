package com.eucsoft.beeper.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import com.eucsoft.beeper.config.ServerConfig;
import com.eucsoft.beeper.controller.SocketController;

public class Server {
	
	public static void main(String[] args) {
		try {
			ServerSocket serverSocket = new ServerSocket( ServerConfig.getServerSocketTimeout() );
			serverSocket.setSoTimeout(SERVER_SOCKET_TIMEOUT);
			listen(serverSocket);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static void listen(ServerSocket serverSocket) throws IOException {
		while(!IS_SERVER_DIE) {
			try {
				Socket socket = serverSocket.accept();
				processScoket(socket);
			} catch (SocketTimeoutException e) {
//				System.out.println("timeout");
			} catch (SocketException e) {
				e.printStackTrace();
			}
		}
	}
	
	private static void processScoket (Socket socket) {
		System.out.println("Client connected");
		SocketController socketController = new SocketController(socket);
		
		Executor executor = Executors.newSingleThreadExecutor();
		executor.execute(socketController);
	}

}
