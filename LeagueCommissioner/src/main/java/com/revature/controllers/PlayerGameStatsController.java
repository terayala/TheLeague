package com.revature.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.revature.services.StatsService;

@Controller
@RequestMapping(value = "/viewStats")
public class PlayerGameStatsController {
	
	@Autowired
	StatsService statsService;

	@RequestMapping(method = RequestMethod.GET)
	public String getPlayerGameStatsPage(ModelMap modelMap, HttpSession session) {
		modelMap = statsService.readyTables(modelMap, session);

		return "viewStats";
	}
}
