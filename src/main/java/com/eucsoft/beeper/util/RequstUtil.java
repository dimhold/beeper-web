package com.eucsoft.beeper.util;

import com.eucsoft.beeper.server.Requset;

public class RequstUtil {

	public static Requset getRequst(byte[] requestBytes) {
		if (isBinary(requestBytes)) {
			Requset request = new Requset();
			request.setAction("message");		
			request.setParam("message", requestBytes);
		}
		return null;
	}
	
	private static boolean isBinary(byte[] requestBytes) {
		String request = new String(requestBytes);
		if (request.indexOf("action") == -1) {
			return true;
		}
		
		return false;
	}
	
	private static void readAction() {
		
		
		
	}
	
	public byte[] toBytes() {
		return null;
	}

}
