package com.eucsoft.beeper.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AudioController {
	
    @RequestMapping("/vets")
    public void processGet(@RequestParam("testParam") int testParam, ModelMap model) {
    	System.out.println(testParam);
    }

}
