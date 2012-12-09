package com.eucsoft.beeper.controller;

import java.io.IOException;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.eucsoft.beeper.model.Message;
import com.eucsoft.beeper.service.MessageService;

@Controller
public class MessageController {
	
	@Autowired
	MessageService messageService;
	
	@Autowired
	ServletContext context;
	
	@RequestMapping(value = "/upload.do", method = RequestMethod.POST)
	@ResponseBody
    public String handleMessageUpload(@RequestParam("userId") Long userId, @RequestParam("channelId") Long channelId, @RequestParam("file") MultipartFile file) {
        if (!file.isEmpty()) {
            try {
				byte[] bytes = file.getBytes();
				Message msg = messageService.createNewMessage(bytes, userId, channelId, context.getRealPath("/"));
				BeeperMessageInbound.broadcastAll(msg);
			} catch (IOException e) {
				return "uploadFailure";
			}
           return "uploadSuccess";
       } else {
           return "uploadFailure";
       }
    }
	
}
