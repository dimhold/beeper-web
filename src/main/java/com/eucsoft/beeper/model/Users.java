package com.eucsoft.beeper.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Users {
	
	private static HashMap<String, User> users = new HashMap<String, User>();
	
	public static void add(User user) {
		users.put(user.getId(), user);
	}
	
	public static void remove(User user) {
		users.remove(user.getId());
	}
	
	public static void get(String userId) {
		users.get(userId);
		
	}
	
	public static List<User> getFreeUsers() {
		List<User> freeUsers = new ArrayList<User>();
		for(User user: users.values()) {
			if (user.isFree()) {
				freeUsers.add(user);
			}
		}
		return freeUsers;
	}
	
}
