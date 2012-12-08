package com.eucsoft.beeper.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eucsoft.beeper.dao.UserDAO;
import com.eucsoft.beeper.model.User;

@Service
@Transactional
public class UserService {
	
	@Autowired
	private UserDAO userDAO;

	public User createUser(User user) {
		return userDAO.saveAndFlush(user);
	}
	
	public User findById(Long id) {
		return userDAO.findOne(id);
	}
}
