package com.revature.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.revature.beans.Stats;
import com.revature.beans.User;
import com.revature.daos.StatsDAO;
import com.revature.daos.StatsDAOImpl;

@Controller
@RequestMapping(value = "/playergamestats")
public class PlayerGameStatsController {
	
	@Autowired
	User user;
	
	@Autowired
	Stats stat;
	
	@RequestMapping(method = RequestMethod.GET)
	public String getPlayerGameStatsPage(ModelMap modelMap, HttpSession session) {
		System.out.println("stats: GET");
		user = (User) session.getAttribute("user");
		StatsDAO statsDao = new StatsDAOImpl();
		
		List<Stats> stats = statsDao.selectStatsByPlayerId(user.getUserID());
		
		modelMap.addAttribute("stats", stats);
		
		return "playergamestats";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String doPlayerGameStats(@Valid User user, 
								BindingResult bindingResult, 
								ModelMap modelMap, 
								HttpSession session) {
		
		return "playergamestats";
	}
}
