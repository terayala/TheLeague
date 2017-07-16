package com.revature.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.revature.services.SchedulePageService;

@Component
@RequestMapping(path="/viewschedule")
public class ViewScheduleController {
	
	@Autowired
	SchedulePageService service;

	@RequestMapping(method= RequestMethod.GET)
	public String getViewSchedule(ModelMap modelMap, HttpSession session) {
		List<Game> list = service.getGames((User)session.getAttribute("user"), (League)session.getAttribute("league"));
		modelMap.addAttribute("allGames", list);
		return "ViewSchedulePage2";
	}
	
}
