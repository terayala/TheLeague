package com.revature.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/playerGameStats")
public class PlayerGameStatsController {
	
	@RequestMapping(method = RequestMethod.GET)
	public String getPlayerGameStatsPage(ModelMap modelMap) {
		System.out.println("stats: GET");
		
		
		
		return "playerGameStats";
	}
}
