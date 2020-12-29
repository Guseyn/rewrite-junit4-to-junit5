package com.developersguide.junit.suites;
import static org.junit.jupiter.api.Assertions.assertTrue;

import static org.junit.jupiter.api.Assertions.assertFalse;
import org.junit.jupiter.api.Test;

public class LoginServiceTest {
	@Test
	public void authenticateSuccessTest(){
		LoginService login = new LoginService();
		assertTrue("authenticate failed", login.authenticate("demo", "demo"));
	}
	
	@Test
	public void authenticateFailTest(){
		LoginService login = new LoginService();
		assertFalse("authenticate failed", login.authenticate("demo1", "demo"));
	}
}
