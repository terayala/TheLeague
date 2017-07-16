package com.revature.services;

import org.springframework.stereotype.Service;

import com.revature.beans.User;

@Service
public class PasswordService {
	
	public boolean checkPassword(User user, String pwd) {
		String oldPwd = user.getPassword();
		if (oldPwd.equals(pwd)) {
			return true;
		} else{
			return false;
		}		
	}
}
