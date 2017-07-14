package com.revature.controllers;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.revature.beans.League;
import com.revature.beans.Sport;
import com.revature.daos.LeagueDAO;
import com.revature.daos.LeagueDAOImpl;
import com.revature.daos.SportDAOImpl;

@Controller
@RequestMapping(value = "/createleague")
public class CreateLeagueController {

	@RequestMapping(method = RequestMethod.GET)
	public String getLeagueePage(ModelMap modelMap) {
		List<Sport> sports = new SportDAOImpl().selectAllSports();
		modelMap.addAttribute("sports", sports);
		return "CreateLeaguePage";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String doCreateLeague(@RequestParam Map leagueMap, ModelMap modelMap, HttpSession session) {
		League league = null;
		league.setName((String)leagueMap.get("name"));
		league.setSport((Sport)leagueMap.get("sport"));
		if ((boolean)leagueMap.get("ptsOrPct")) {league.setPtsOrPct(1);}
		if ((boolean)leagueMap.get("tiesAllowed")) {league.setTiesAllowed(1);}
		league.setWinPts((int)leagueMap.get("winPts"));
		league.setTiePts((int)leagueMap.get("tiePts"));
		league.setWinOTPts((int)leagueMap.get("winOTPts"));
		league.setLossOTPts((int)leagueMap.get("lossOTPts"));
		LeagueDAO dao = new LeagueDAOImpl();
		dao.createLeague(league);
		
		return "createteam";
	}
}
