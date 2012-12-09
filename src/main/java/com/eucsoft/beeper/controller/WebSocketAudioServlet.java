package com.eucsoft.beeper.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.catalina.websocket.StreamInbound;
import org.apache.catalina.websocket.WebSocketServlet;
import org.springframework.beans.factory.annotation.Autowired;

import com.eucsoft.beeper.model.User;
import com.eucsoft.beeper.service.UserService;

@SuppressWarnings("serial")
public class WebSocketAudioServlet extends WebSocketServlet {
	
	@Autowired
	UserService userService;
	
    @Override
	protected StreamInbound createWebSocketInbound(String subProtocol, HttpServletRequest request) {
    	User user = userService.createUser(new User());
    	return new BeeperMessageInbound(user);
	}

}