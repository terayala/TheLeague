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

import com.revature.beans.League;
import com.revature.beans.Sport;
import com.revature.daos.LeagueDAO;
import com.revature.daos.LeagueDAOImpl;
import com.revature.daos.SportDAOImpl;

@Controller
@RequestMapping(value = "/createleague")
public class CreateLeagueController {

	@RequestMapping(method = RequestMethod.GET)
	public String getHomePage(ModelMap modelMap) {
		List<Sport> sports = new SportDAOImpl().selectAllSports();
		modelMap.addAttribute("sports", sports);
		return "CreateLeaguePage";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String doCreateUser(@Valid League league, BindingResult bindingResult, ModelMap modelMap, HttpSession session) {
		if (bindingResult.hasErrors()) {
			return "CreateLeaguePage";
		}
		LeagueDAO dao = new LeagueDAOImpl();
		dao.createLeague(league);
		
		return "createteam";
	}
}
