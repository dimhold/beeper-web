package com.eucsoft.beeper.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.eucsoft.beeper.util.Constants;

@Controller
public class MessageController {
	
	@RequestMapping(value = "/upload.do", method = RequestMethod.POST)
    public String handleMessageUpload(@RequestParam("name") String name, @RequestParam("file") MultipartFile file) {
        if (!file.isEmpty()) {
            try {
				byte[] bytes = file.getBytes();
				String uploadFolder = Constants.DATA_DIRECTORY;
				FileOutputStream fos = new FileOutputStream(uploadFolder + File.separator + "1.mp3");
				fos.write(bytes);
				fos.flush();
				fos.close();
			} catch (IOException e) {
				return "redirect:uploadFailure";
			}
           return "redirect:uploadSuccess";
       } else {
           return "redirect:uploadFailure";
       }
    }
	
}
