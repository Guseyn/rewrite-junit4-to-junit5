package com.developersguide.junit.suites;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class UserServiceTest {
	private User user;
	private UserService userService = new UserService();
	
	@BeforeEach
	public void setup(){
		user = new User(100, "ramesh");
	}
	
	@Test
	public void userServiceTest(){
		userService.createUser(user);
		List<User> users = userService.getUsers();
		assertEquals(1, users.size());
		userService.deleteUser(user);
		users = userService.getUsers();
		assertEquals(0, users.size());
	}
	
}
