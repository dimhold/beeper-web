package com.eucsoft.beeper.service;

import org.testng.annotations.Test;

import com.eucsoft.spring.AbstractSpringTest;

public class UserServiceTest extends AbstractSpringTest {
	
	 	@Test
		public void testServiceExistance() {
	 		assert(getUserService()!=null);
	 	}

}
