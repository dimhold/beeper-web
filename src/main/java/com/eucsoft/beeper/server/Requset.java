package com.eucsoft.beeper.server;

import java.util.HashMap;

import com.eucsoft.beeper.user.User;


public class Requset {

	private String action = "";
	private HashMap<String, Object> map = new HashMap<String, Object>();
	
	public String getAction() {
		return null;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public void setParam(String param, byte[] value) {
		map.put(param, value);
	}
	
	public Object getParam(String param) {
		return map.get(param);
	}

	public User getUser() {
		return null;
	}

}
