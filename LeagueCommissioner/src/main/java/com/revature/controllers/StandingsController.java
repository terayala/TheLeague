package com.revature.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.revature.beans.User;
import com.revature.daos.UserDAO;
import com.revature.daos.UserDAOImpl;

@Controller
@RequestMapping(value = "/standings")
public class StandingsController {
	
	@Autowired
	User tempUser;
	
	@RequestMapping(method = RequestMethod.GET)
	public String getHomePage(ModelMap modelMap) {
		return "standings";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String doStandings(@Valid User user, BindingResult bindingResult, ModelMap modelMap, HttpSession session) {
		
		return "standings";
	}

}
