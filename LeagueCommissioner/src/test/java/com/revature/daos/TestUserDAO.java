package com.revature.daos;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.revature.beans.User;

public class TestUserDAO {

	UserDAOImpl userDao = new UserDAOImpl();
	
	@Test
	public void testCreateUser() {
		User user = new User(null, "junit", "junit", 3, "junit@junit.com", "junit1928352439", "pass", 1);
		userDao.createUser(user);
		assertEquals("junit1928352439", user.getUsername());
		userDao.deleteUser(user);
	}
	
	/*@Test
	public void testSelectUserById() {
		User user = userDao.selectUserById(1);
		assertEquals("rdelort0", user.getUsername());
	}*/

}
