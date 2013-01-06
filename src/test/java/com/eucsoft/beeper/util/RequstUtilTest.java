package com.eucsoft.beeper.util;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.eucsoft.beeper.server.Request;

public class RequstUtilTest {

	@Test
	public void getRequst() {
		String requset = "action: connect, id: 8484845184, info: android4.2";
		
		Request actual = RequstUtil.getRequst(requset.getBytes());
		
		Assert.assertEquals(actual.getAction(), "connect");
		Assert.assertEquals(actual.getParam("id"), "8484845184");
		Assert.assertEquals(actual.getParam("info"), "android4.2");
	}

	@Test
	public void toBytes() {
		Request request = new Request();
		request.setAction("connect");
		request.setParam("id", "8484845184");
		request.setParam("info", "android4.2");
		
		byte[] actual = RequstUtil.toBytes(request);
		
		System.out.println(new String(actual));
		byte[] expected = "action: connect, id: 8484845184, info: android4.2".getBytes();
		
		Assert.assertEquals(actual, expected);
	}
}
