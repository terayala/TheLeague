package com.revature.controllers;

import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/standings")
public class StandingsController {
	
	@RequestMapping(method = RequestMethod.GET)
	public String getHomePage(ModelMap modelMap, HttpSession session) {
		if (session == null) {
			return "errorpage";
		} else {
			return "standings";
		}
	}

}
