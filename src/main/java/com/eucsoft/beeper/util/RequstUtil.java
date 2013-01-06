package com.eucsoft.beeper.util;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.eucsoft.beeper.server.Request;

public class RequstUtil {

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
	
	private static boolean isBinary(byte[] requestBytes) {
		String request = new String(requestBytes);
		if (request.indexOf("action") == -1) {
			return true;
		}
		
		return false;
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

		String action = readAction(requestString);
		request.setAction(action);
		
		HashMap<String, Object> params = readParams(requestString);
		request.setParams(params);
		return request;
	}
	
	private static String readAction(String requestString) {
		Matcher matcher = Pattern.compile("action: ([^,]+)").matcher(requestString);
		if (matcher.find()) {
			return matcher.group(1);
		}
		return null;
	}
	
	private static HashMap<String, Object> readParams(String request) {
		HashMap<String, Object> params = new HashMap<String, Object>();
		Matcher matcher = Pattern.compile("([^:, ]+): ([^,]+)").matcher(request);
		while (matcher.find()) {
			String key = matcher.group(1);
			String value = matcher.group(2);
			params.put(key, value);
		}
		
		return params;
	}
	
}
