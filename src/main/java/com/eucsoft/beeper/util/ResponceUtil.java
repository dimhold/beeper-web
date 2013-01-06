package com.eucsoft.beeper.util;

import com.eucsoft.beeper.server.Responce;

public class ResponceUtil extends RequestResponceUtil {

	public static byte[] toBytes(Responce responce) {
		String action = responce.getAction();
		String status = responce.getStatus();
		
		StringBuilder responceString = new StringBuilder();
		responceString.append("action: ").append(action);
		responceString.append(", ").append("status: ").append(status);
		
		return responceString.toString().getBytes();
	}
	
}
