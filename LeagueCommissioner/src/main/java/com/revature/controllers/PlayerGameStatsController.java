package com.revature.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.revature.beans.Stats;
import com.revature.beans.User;
import com.revature.daos.StatsDAO;
import com.revature.daos.StatsDAOImpl;

@Controller
@RequestMapping(value = "/playerGameStats")
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
		
		return "playerGameStats";
	}
}
