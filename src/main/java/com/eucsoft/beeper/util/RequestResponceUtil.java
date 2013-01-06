package com.eucsoft.beeper.util;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.eucsoft.beeper.user.User;

public abstract class RequestResponceUtil {
	
	protected static boolean isBinary(byte[] requestBytes) {
		String request = new String(requestBytes);
		if (request.indexOf("action") == -1) {
			return true;
		}
		
		return false;
	}
	
	private static String readAction(String requestString) {
		Matcher matcher = Pattern.compile("action: ([^,]+)").matcher(requestString);
		if (matcher.find()) {
			return matcher.group(1);
		}
		return null;
	}
	
	protected static String readParam(String key, String request) {
		HashMap<String, Object> params = new HashMap<String, Object>();
		Matcher matcher = Pattern.compile(key + ": [^,]+)").matcher(request);
		if (matcher.find()) {
			return matcher.group(1);
		}
		return null;
	}
	
	protected static HashMap<String, Object> readParams(String request) {
		HashMap<String, Object> params = new HashMap<String, Object>();
		Matcher matcher = Pattern.compile("([^:, ]+): ([^,]+)").matcher(request);
		while (matcher.find()) {
			String key = matcher.group(1);
			String value = matcher.group(2);
			params.put(key, value);
		}
		
		return params;
	}
	
	protected static User buildUser(String request) {
		String userId = readParam("id", request);
		User user = new User(userId);
		return user;
	}

}
