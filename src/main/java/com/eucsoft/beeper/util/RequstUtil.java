package com.eucsoft.beeper.util;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.eucsoft.beeper.model.User;
import com.eucsoft.beeper.server.Request;

public class RequstUtil extends RequestResponceUtil {

	public static Request getRequst(byte[] requestBytes) {
		if (isBinary(requestBytes)) {
			return readBinary(requestBytes);
		} else {
			return readString(requestBytes);
		}
	}
	
	public static byte[] toBytes(Request request) {
		StringBuilder requestString = new StringBuilder();
		requestString.append("action: ").append(request.getAction());
		
		HashMap<String, Object> params =request.getParams();
		
		for (Map.Entry<String, Object> param: params.entrySet()) {
		    String key = param.getKey();
		    Object value = (String) param.getValue();
		    requestString.append(", ").append(key).append(": ").append(value);
		}
		return requestString.toString().getBytes();
	}
	
	private static Request readBinary(byte[] requestBytes) {
		Request request = new Request();
		request.setAction("message");		
		request.setParam("message", requestBytes);
		
		return request;
	}
	
	private static Request readString(byte[] requestBytes) {
		Request request = new Request();
		
		String requestString = new String(requestBytes);
		
		String action = readParam("action", requestString);
		request.setAction(action);
		
		HashMap<String, Object> params = readParams(requestString);
		request.setParams(params);
		return request;
	}
	
}
