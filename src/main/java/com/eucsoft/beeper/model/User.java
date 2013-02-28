package com.eucsoft.beeper.model;

public class User {

	private String userId;
	
	private boolean isFree;
	
	public User(String userId) {
		this.userId = userId;
	}
	
	public String getId() {
		return userId;
	}
	
	public boolean isFree() {
		return this.isFree;
	}
	
	public void free() {
		this.isFree = false;
	}
	
	public void talk() {
		this.isFree = true;
	}
	
}
