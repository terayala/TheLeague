package com.revature.services;

import org.springframework.stereotype.Component;

import com.revature.beans.User;
import com.revature.daos.UserDAOImpl;
import com.revature.daos.UserDAO;

@Component
public class UserService {
	public User auth(User user) {
		User authUser = null;
		UserDAO userDao = new UserDAOImpl();
		
		System.out.println("UserService invoked.");
		System.out.println("user name: " + user.getUsername());
		System.out.println("user password: " + user.getPassword());
		
		authUser = userDao.selectUserByUsername(user.getUsername());
		
		if(user.getUsername().equals(authUser.getUsername()) && user.getPassword().equals(authUser.getPassword())) {
			return authUser;
		} else {
			return null;
		}
		/*
		 * This authentication will return null in all situations where
		 * both the username and the password are not correct.
		 */
	}
}
