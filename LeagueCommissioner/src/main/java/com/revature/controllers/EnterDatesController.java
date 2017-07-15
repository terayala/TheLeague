package com.revature.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

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
@RequestMapping(value = "/enterdates")
public class EnterDatesController {
	
	@RequestMapping(method = RequestMethod.POST)
	public String doEnterDates(@Valid Team team, BindingResult bindingResult, ModelMap modelMap, HttpSession session) {

		if (bindingResult.hasErrors()) {
			return "enterdates";
		}

		
		return "enterdates";
	}
	

	@RequestMapping(method = RequestMethod.GET)
	public String getEnterDatesPage(ModelMap modelMap, HttpSession session){
		TeamDAO dao = new TeamDAOImpl();
		
		
		List<Team> teams= dao.selectTeamsByLeague(((League) session.getAttribute("league")).getLeagueID());
		
		
		modelMap.addAttribute("count", teams.size());
		

		return "enterdates";
	}
	

}
