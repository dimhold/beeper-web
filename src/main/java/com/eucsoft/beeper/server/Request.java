package com.eucsoft.beeper.server;

import java.util.HashMap;

import com.eucsoft.beeper.user.User;


public class Request {

	private String action = "";
	private HashMap<String, Object> params = new HashMap<String, Object>();
	
	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public void setParam(String param, Object value) {
		params.put(param, value);
	}
	
	public void setParams(HashMap<String, Object> params) {
		this.params.putAll(params);
	}
	
	public HashMap<String, Object> getParams() {
		return params;
	}
	
	public Object getParam(String param) {
		return params.get(param);
	}

	public User getUser() {
		return null;
	}


}
