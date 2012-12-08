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

	public User createPlan(User plan) {
		return userDAO.saveAndFlush(plan);
	}
}
