package com.eucsoft.beeper.service;

import org.testng.annotations.Test;

import com.eucsoft.beeper.model.User;
import com.eucsoft.spring.AbstractSpringTest;

public class UserServiceTest extends AbstractSpringTest {
	
	 	@Test
		public void testServiceExistance() {
	 		assert(getUserService()!=null);
	 	}
	 	
	 	@Test
		public void testUserCreate() {
	 		User user = new User();
	 		user = getUserService().createUser(user);
	 		assert(user!=null);
	 		user = getUserService().findById(user.getId());
	 		assert(user!=null);
	 	}

}
