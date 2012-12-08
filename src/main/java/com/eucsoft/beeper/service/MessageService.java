package com.eucsoft.beeper.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eucsoft.beeper.dao.MessageDAO;
import com.eucsoft.beeper.model.Message;

@Service
@Transactional
public class MessageService {
	
	@Autowired
	private MessageDAO messageDAO;

	public Message createUser(Message message) {
		return messageDAO.saveAndFlush(message);
	}
	
	public Message findById(Long id) {
		return messageDAO.findOne(id);
	}
}
