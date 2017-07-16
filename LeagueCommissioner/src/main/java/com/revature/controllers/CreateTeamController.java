package com.revature.controllers;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.revature.beans.League;
import com.revature.beans.Team;
import com.revature.beans.User;
import com.revature.daos.TeamDAO;
import com.revature.daos.TeamDAOImpl;

@Controller
@RequestMapping(value = "/createteam")
public class CreateTeamController {
	
	@Autowired
	Team teamTemplate;
	
	@RequestMapping(method = RequestMethod.GET)
	public String getTeamPage(ModelMap modelMap, HttpSession session){
		if (session == null) {
			return "index";
		} else if (((User)session.getAttribute("user")).getRole() != 3) {
			return "errorpage";
		} else {
			modelMap.addAttribute("team", teamTemplate);
			return "createteam";
		}
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String doCreateTeam(@RequestParam Map<String, String> teamMap, ModelMap modelMap, HttpSession session) {
		if (session == null) {
			return "index";
		} else {
			teamTemplate.setName((String)teamMap.get("teamName"));
			teamTemplate.setNickname((String)teamMap.get("nickname"));
			
			String primaryColorString=((String)teamMap.get("primaryColor"));
			String secondaryColorString= ((String)teamMap.get("secondaryColor"));
	
			Integer primaryColorInt=Integer.decode(primaryColorString);
			Integer secondaryColorInt=Integer.decode(secondaryColorString);
			
			teamTemplate.setPrimaryColor(primaryColorInt);
			teamTemplate.setSecondaryColor(secondaryColorInt);
	
			TeamDAO dao = new TeamDAOImpl();
			teamTemplate.setLeague((League)session.getAttribute("league"));
			dao.createTeam(teamTemplate);
			
			return "createteam";
		}
	}
	
}
