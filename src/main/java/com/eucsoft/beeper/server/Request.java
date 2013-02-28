package com.eucsoft.beeper.server;

import java.util.HashMap;

import com.eucsoft.beeper.model.User;


public class Request {

	private User user;
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
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	

}
