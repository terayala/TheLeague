package com.revature.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.revature.beans.League;

@Controller
@RequestMapping(value = "/home")
public class HomeController {
	
	@RequestMapping(method = RequestMethod.GET)
	public String getHomePage(ModelMap modelMap) {
		return "home";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String chooseLeague(@RequestBody League league, HttpSession session) {
		session.setAttribute("league", league);
		return "home";
	}
}
