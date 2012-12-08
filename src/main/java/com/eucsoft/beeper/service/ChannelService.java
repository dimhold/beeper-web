package com.eucsoft.beeper.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eucsoft.beeper.dao.ChannelDAO;
import com.eucsoft.beeper.model.Channel;


@Service
@Transactional
public class ChannelService {
	@Autowired
	private ChannelDAO channelDAO;

	public Channel createChannel(Channel channel) {
		return channelDAO.saveAndFlush(channel);
	}
	
	public Channel findById(Long id) {
		return channelDAO.findOne(id);
	}
}
