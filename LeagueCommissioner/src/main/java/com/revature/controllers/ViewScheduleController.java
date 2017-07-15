package com.revature.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.revature.beans.Game;
import com.revature.beans.League;
import com.revature.beans.Team;
import com.revature.beans.User;
import com.revature.daos.GameDAO;
import com.revature.daos.GameDAOImpl;
import com.revature.daos.TeamDAO;
import com.revature.daos.TeamDAOImpl;

@Component
@RequestMapping(path="/viewschedule")
public class ViewScheduleController {

	/*
	 * if commissioner, just show all schedules - with approve scores
	 * if coach, enter scores on games with no scores (all games in league)
	 * if player show regular table with games of their team
	 */
	@RequestMapping(method= RequestMethod.GET)
	public String getViewSchedule(ModelMap modelMap, HttpSession session) {
		User user = (User) session.getAttribute("user");
		League league = (League) session.getAttribute("league");
		TeamDAO teamDAO = new TeamDAOImpl();
		GameDAO gameDAO = new GameDAOImpl();
		List<Game> list = null;
		if (user.getRole() == 3) {
			List<Team> teams = teamDAO.selectTeamsByLeague(league.getLeagueID());
			list = gameDAO.getScheduleByLeague(teams);
		} else {
			list = gameDAO.viewScheduleByTeam(((User)session.getAttribute("user")).getTeam().getTeamID());
		}
		modelMap.addAttribute("allGames", list);
		return "ViewSchedulePage";
	}
	
}
