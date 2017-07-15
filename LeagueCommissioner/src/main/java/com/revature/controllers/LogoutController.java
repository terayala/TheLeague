package com.revature.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.revature.beans.User;

@Controller
@RequestMapping(value = "/logout")
public class LogoutController {
	
	@Autowired
	User userTemplate;
	
	@RequestMapping(method = RequestMethod.GET)
	public String logout(ModelMap modelMap, HttpSession session) {
		session.invalidate();
		userTemplate.setFirstName("firstname");
		userTemplate.setLastName("lastname");
		userTemplate.setEmail("email@email.com");
		modelMap.addAttribute("user", userTemplate);
		return "login";
	}
}
