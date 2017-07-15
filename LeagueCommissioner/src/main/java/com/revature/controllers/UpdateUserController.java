package com.revature.controllers;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.revature.beans.User;
import com.revature.daos.UserDAO;
import com.revature.daos.UserDAOImpl;
import com.revature.services.PasswordService;

@Controller
@RequestMapping(value = "/updateuser")
public class UpdateUserController {
	
	@Autowired
	PasswordService service;
	
	@RequestMapping(method = RequestMethod.GET)
	public String getUser(ModelMap modelMap) {
		return "ViewUserPage";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String doCreateUser(@RequestParam Map<String, Object> userMap, ModelMap modelMap, HttpSession session) {
		UserDAO dao = new UserDAOImpl();
		User user = dao.selectUserByUsername(((User)session.getAttribute("user")).getUsername());
		if (userMap.get("oldpwd") != null) {
			if ( service.checkPassword(user, (String)userMap.get("oldpwd")) ) {
				user.setPassword( (String) userMap.get("pwd") );
			}
		} 
		user.setFirstName( (String) userMap.get("fname") );
		user.setLastName( (String) userMap.get("lname") );
		user.setEmail( (String) userMap.get("email") );
		if (((User)session.getAttribute("user")).getRole() == 1) {
			user.setUniform( Integer.parseInt( (String) userMap.get("uniform") ));
			dao.updateUser(user);
		} else {
			dao.updateUser(user);
		}
		session.setAttribute("user", user);
		return "home";
	}

}
