package com.revature.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.revature.beans.League;
import com.revature.beans.Team;
import com.revature.daos.TeamDAO;
import com.revature.daos.TeamDAOImpl;

@Controller
@RequestMapping(value = "/createuser")
public class CreateTeamController {
	
	@Autowired
	League league;
	
	@Autowired
	Team team;
	
	
	@RequestMapping(method = RequestMethod.POST)
	public String doCreateTeam(@Valid Team team, BindingResult bindingResult, ModelMap modelMap, HttpSession session) {

		if (bindingResult.hasErrors()) {
			return "createteam";
		}
		
		TeamDAO ld =  new TeamDAOImpl();
		league.setLeagueID(league.getLeagueID());
		ld.createTeam(team);
		
		return "home";
	}
	

}
