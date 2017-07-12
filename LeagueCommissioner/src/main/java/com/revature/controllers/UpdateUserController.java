package com.revature.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.revature.beans.User;
import com.revature.daos.UserDAO;
import com.revature.daos.UserDAOImpl;

@Controller
@RequestMapping(value = "/updateuser")
public class UpdateUserController {
	
	@RequestMapping(method = RequestMethod.POST)
	public String doCreateUser(@Valid User user, BindingResult bindingResult, ModelMap modelMap, HttpSession session) {

		if (bindingResult.hasErrors()) {
			return "updateuser";
		}
		
		UserDAO dao =  new UserDAOImpl();
		dao.updateUser(user);
		
		return "home";
	}

}
