package com.revature.controllers;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.revature.beans.Game;
import com.revature.beans.League;
import com.revature.beans.Team;
import com.revature.beans.User;
import com.revature.daos.GameDAO;
import com.revature.daos.GameDAOImpl;
import com.revature.daos.TeamDAO;
import com.revature.daos.TeamDAOImpl;
import com.revature.services.LeagueScheduleService;
import com.revature.services.SchedulePageService;

@Controller
@RequestMapping(value = "/enterdates")

public class EnterDatesController {

	@Autowired
	LeagueScheduleService ls_service;	
	
	@Autowired
	SchedulePageService sp_service;

	@RequestMapping(method = RequestMethod.POST)
	public String doEnterDates(@RequestParam Map<String, String> dateMap, ModelMap modelMap, HttpSession session) {
		if (session == null) {
			return "errorpage";
		} else {
			ArrayList<Game> games = new ArrayList<>();
			ArrayList<Integer> teams = new ArrayList<>();
			ArrayList<Timestamp> dates = new ArrayList<>();
			GameDAO gameDAO = new GameDAOImpl();
			TeamDAO dao= new TeamDAOImpl();
			
			for (Map.Entry<String, String> entry : dateMap.entrySet()) {
				String str = entry.getValue();
				dates.add(Timestamp.valueOf(str));
			}
			List<Team> teamList = dao.selectTeamsByLeague(((League)session.getAttribute("league")).getLeagueID());
			for(Team i: teamList){
				teams.add(i.getTeamID());
	
			}
			games= ls_service.MakeSchedule(teams, dates);
			for(int i=0; i< games.size(); i++) {
				gameDAO.createGame(games.get(i));
			}
			
			List<Game> list = sp_service.getGames((User)session.getAttribute("user"), (League)session.getAttribute("league"));
			modelMap.addAttribute("allGames", list);
			return "ViewSchedulePage";
		}
	}

	@RequestMapping(method = RequestMethod.GET)
	public String getEnterDatesPage(ModelMap modelMap, HttpSession session) {
		if (session == null) {
			return "errorpage";
		} else {
			TeamDAO dao = new TeamDAOImpl();
			List<Team> teams = dao.selectTeamsByLeague(((League) session.getAttribute("league")).getLeagueID());
			if(teams.size()%2==0){
				modelMap.addAttribute("count", teams.size()*2-2);
			}
			else{
				modelMap.addAttribute("count", teams.size()*2);
			}
			return "enterdates";
		}
	}

}
