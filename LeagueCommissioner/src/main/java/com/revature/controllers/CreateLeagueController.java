package com.revature.controllers;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.revature.beans.League;
import com.revature.beans.Sport;
import com.revature.beans.Team;
import com.revature.daos.LeagueDAO;
import com.revature.daos.LeagueDAOImpl;
import com.revature.daos.SportDAOImpl;

@Controller
@RequestMapping(value = "/createleague")
public class CreateLeagueController {
	
	@Autowired
	League league;
	
	@Autowired
	Team teamTemplate;

	@RequestMapping(method = RequestMethod.GET)
	public String getLeaguePage(ModelMap modelMap) {
		List<Sport> sports = new SportDAOImpl().selectAllSports();
		Collections.sort(sports);
		modelMap.addAttribute("sports", sports);
		return "CreateLeaguePage";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String doCreateLeague(@RequestParam Map<String, Object> leagueMap, ModelMap modelMap, HttpSession session) {
		league.setName((String)leagueMap.get("Name"));
		Sport sport = new SportDAOImpl().selectSportById(Integer.parseInt((String)leagueMap.get("Sport")));
		league.setSport(sport);
		league.setPtsOrPct(Integer.parseInt((String)leagueMap.get("ptsOrPct")));
		try {
			if (leagueMap.get("tiesAllowed") != null) {
				league.setTiesAllowed(1);
			} 
		} catch (Exception e) {
			league.setTiesAllowed(0);
		}		
		league.setWinPts(Integer.parseInt((String)leagueMap.get("winPts")));
		league.setTiePts(Integer.parseInt((String)leagueMap.get("tiePts")));
		league.setWinOTPts(Integer.parseInt((String)leagueMap.get("winOTPts")));
		league.setLossOTPts(Integer.parseInt((String)leagueMap.get("lossOTPts")));
		LeagueDAO dao = new LeagueDAOImpl();
		Integer leagueId = dao.createLeague(league);
		session.setAttribute("league", dao.selectLeagueById(leagueId));
		modelMap.addAttribute("team", teamTemplate);
		return "createteam";
	}
}
