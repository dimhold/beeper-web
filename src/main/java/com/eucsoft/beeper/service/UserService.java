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
	
	@Autowired
	ChannelService channelService;

	public User createUser(User user) {
		User newUser = userDAO.saveAndFlush(user);
		assignChannleToUser(newUser);
		return newUser;
	}
	
	private void assignChannleToUser(User newUser) {
		//TODO: pick channel using some algorithm.
		newUser.setChannel(channelService.findById(1L));
	}

	public User findById(Long id) {
		return userDAO.findOne(id);
	}
}
