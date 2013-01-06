package com.eucsoft.beeper.user;

public class User {

	private String userId;
	
	private boolean isFree;
	
	private ConversationHistory history;
	
	public User(String userId) {
		this.userId = userId;
		history = new ConversationHistory();
	}
	
	public String getId() {
		return userId;
	}
	
	public boolean isFree() {
		return this.isFree;
	}
	
	
	

}
