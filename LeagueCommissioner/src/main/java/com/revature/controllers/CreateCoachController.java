package com.revature.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.revature.beans.Team;
import com.revature.beans.User;
import com.revature.daos.UserDAO;
import com.revature.daos.UserDAOImpl;

@Controller
@RequestMapping(value = "/createcoach")
public class CreateCoachController {

	@Autowired
	User user;

	@Autowired
	Team teamID;
	

	@RequestMapping(method = RequestMethod.POST)
	public String doCreateCoach(@Valid User user, BindingResult bindingResult, ModelMap modelMap, HttpSession session) {

		if (bindingResult.hasErrors()) {
			return "createcoach";
		}
		
		UserDAO ud =  new UserDAOImpl();
		user.setActive(1);
		user.setRole(2);
		
		ud.createUser(user);
		
		return "createcoach";
	}

}
