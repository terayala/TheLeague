package com.revature.controllers;

import java.util.ArrayList;
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
import com.revature.daos.UserDAO;
import com.revature.daos.UserDAOImpl;

@Controller
@RequestMapping(value = "/viewStats")
public class PlayerGameStatsController {
	
	@Autowired
	User user;
	
	@Autowired
	Stats stat;
	
	@RequestMapping(method = RequestMethod.GET)
	public String getPlayerGameStatsPage(ModelMap modelMap, HttpSession session) {
		user = (User) session.getAttribute("user");
		StatsDAO statsDao = new StatsDAOImpl();
		List<Stats> stats = new ArrayList<>();
		List<List<Stats>> statsStats = new ArrayList<>();
		List<String> names = new ArrayList<>();
		if(user.getRole() == 1) {
			stats = statsDao.selectStatsByPlayerId(user.getUserID());
			modelMap.addAttribute("stats", stats);
		}
		UserDAO usersDao = new UserDAOImpl();
		List<User> users = usersDao.selectUsersByTeam(user.getTeam().getTeamID());
		
		List<List<String>> aggTable = new ArrayList<>();
		
		statsStats = statsDao.selectStatsListByPlayers(users);
		List<String> nameTemp = new ArrayList<>();
		for(List<Stats> stats2 : statsStats) {
			for(Stats s : stats2) {
				nameTemp = new ArrayList<>();
				nameTemp.add(s.getPlayer().getFirstName() + " " + s.getPlayer().getLastName());
				aggTable.add(nameTemp);
				break;
			}
		}
		
		int aggNum = 0;
		int i = 0;
		List<String> allTemp = new ArrayList<>();
		for(List<Stats> stats2 : statsStats) {
			aggNum = 0;
			allTemp = new ArrayList<>();
			for(Stats s : stats2) {
				aggNum += s.getPointsScored();
			}
			allTemp = aggTable.get(i);
			allTemp.add(String.valueOf(aggNum));
			aggTable.set(i, allTemp);
			i++;
		}
		
		modelMap.addAttribute("aggTable", aggTable);
		
		return "viewStats";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String doPlayerGameStats(@Valid User user, 
								BindingResult bindingResult, 
								ModelMap modelMap, 
								HttpSession session) {
		
		return "viewStats";
	}
}
