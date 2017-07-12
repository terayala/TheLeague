package com.revature.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.revature.beans.User;

@Controller
@RequestMapping(value = "/", method = RequestMethod.GET)
public class IndexController {
	@Autowired
	User emptyUser;
	
	@RequestMapping(method = RequestMethod.GET)
	public String getLoginPage(ModelMap modelMap) {
		System.out.println("index GET");
		modelMap.addAttribute("user", emptyUser);
		return "login";
	}
}
