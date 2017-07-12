package com.revature.services;

import org.springframework.stereotype.Component;

import com.revature.beans.User;

@Component
public class UserService {
	public User auth(User user) {
		User authUser = null;
		
		if(user.getUsername().equals("admin") && user.getPassword().equals("admin")) {
			authUser = user;
		}
		
		return authUser;
		/*
		 * This authentication will return null in all situations where
		 * both the username and the password are not correct.
		 */
	}
}
