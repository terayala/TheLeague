package com.revature.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.revature.beans.Game;
import com.revature.beans.User;
import com.revature.daos.GameDAO;
import com.revature.daos.GameDAOImpl;

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
		GameDAO dao = new GameDAOImpl();
		List<Game> list = dao.viewScheduleByTeam(((User)session.getAttribute("user")).getTeam().getTeamID());
		modelMap.addAttribute("allGames", list);
		return "ViewSchedulePage";
	}
	
}
