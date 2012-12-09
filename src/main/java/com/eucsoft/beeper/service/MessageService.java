package com.eucsoft.beeper.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eucsoft.beeper.dao.MessageDAO;
import com.eucsoft.beeper.model.Message;
import com.eucsoft.beeper.util.Constants;
import com.eucsoft.util.EncoderDecoder;

@Service
@Transactional
public class MessageService {
	
	@Autowired
	private MessageDAO messageDAO;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ChannelService channelService;

	public Message createMessage(Message message) {
		return messageDAO.saveAndFlush(message);
	}
	
	public Message findById(Long id) {
		return messageDAO.findOne(id);
	}
	
	public Message createNewMessage(byte[] data, Long userId, Long channelId, String contextPath) throws IOException {
		Date date = new Date();
		String name = EncoderDecoder.encode(new Random().nextInt(100)) + date.hashCode() + Constants.MESSAGE_FILE_EXTENSION;
		saveFileOnServer(data, name, contextPath);
		
		Message msg = new Message();
		msg.setLocation(name);
		msg.setDate(date);
		msg.setChannel(channelService.findById(channelId));
		msg.setUser(userService.findById(userId));
		return createMessage(msg);
	}

	private void saveFileOnServer(byte[] data, String name, String contextPath) throws IOException {
		FileOutputStream fos = new FileOutputStream(contextPath + File.separator + Constants.DATA_DIRECTORY + File.separator + name);
		fos.write(data);
		fos.flush();
		fos.close();
	}
}
