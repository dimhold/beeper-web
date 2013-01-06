package com.eucsoft.beeper.user;

import java.util.LinkedList;
import java.util.List;

public class ConversationHistory {
	
	private List<User> users;
	
	public ConversationHistory() {
		users = new LinkedList<User>();
	}
	
	public void push(User user) {
		users.add(user);
	}
	
	public boolean contains(User user) {
		return users.contains(user);
	}
	
	public User pop() {
		return users.remove(0);
	}
	

}
