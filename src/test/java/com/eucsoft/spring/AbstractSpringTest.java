package com.eucsoft.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.eucsoft.beeper.service.UserService;

public abstract class AbstractSpringTest {
	
	private UserService userService;
	
	@BeforeSuite
	public void setupContext() {
		ApplicationContext context = 
		    	   new ClassPathXmlApplicationContext(new String[] {"META-INF/spring-context/context.xml"});
		 
		    	userService = (UserService)context.getBean("userService");
		    	System.out.println(userService);
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	

}
