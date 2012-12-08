package com.eucsoft.beeper.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping("/editPet.do")
@SessionAttributes("pet")
public class AudioController {
	
    @RequestMapping(method = RequestMethod.GET)
    public void processGet(@RequestParam("testParam") int testParam, ModelMap model) {
    	System.out.println(testParam);
    }

    @RequestMapping(method = RequestMethod.POST)
    public void processPost(@RequestParam("testParamPost") int testParamPost, ModelMap model) {
    	System.out.println(testParamPost);
    }
}
