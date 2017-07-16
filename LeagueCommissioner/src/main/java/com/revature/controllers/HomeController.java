package com.revature.controllers;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.revature.beans.League;
import com.revature.daos.LeagueDAOImpl;

@Controller
@RequestMapping(value = "/home")
public class HomeController {
	
	@RequestMapping(method = RequestMethod.GET)
	public String getHomePage(@RequestParam Map<String, String> homeMap, ModelMap modelMap, HttpSession session) {
		if (session == null) {
			return "errorpage";
		} else {
			League league = new LeagueDAOImpl().selectLeagueById( Integer.parseInt(homeMap.get("leagueId")) );
			session.setAttribute("league", league);
			return "home";
		}
	}

}
