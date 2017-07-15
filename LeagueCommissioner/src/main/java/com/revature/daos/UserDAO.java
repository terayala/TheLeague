package com.revature.daos;

import java.util.List;

import com.revature.beans.User;

public interface UserDAO {

	public void createUser(User user);
	public User selectUserById(Integer id);
	public void updateUser(User user);
	public User selectUserByUsername(String username);
	public List<User> selectUsersByTeam(Integer id);
}
