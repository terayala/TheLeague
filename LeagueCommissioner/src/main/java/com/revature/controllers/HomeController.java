package com.revature.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.revature.beans.User;

@Controller
@RequestMapping(value = "/home")
public class HomeController {
	
	@RequestMapping(method = RequestMethod.GET)
	public String getHomePage(ModelMap modelMap) {
		return "home";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String chooseLeague(@Valid User user, BindingResult bindingResult, ModelMap modelMap, HttpSession session) {
		
		return "home";
	}
}
