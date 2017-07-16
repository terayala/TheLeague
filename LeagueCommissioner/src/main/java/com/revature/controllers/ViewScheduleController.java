package com.revature.controllers;

import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.revature.beans.Game;
import com.revature.beans.League;
import com.revature.beans.User;
import com.revature.services.SchedulePageService;

@Component
@RequestMapping(path="/viewschedule")
public class ViewScheduleController {
	
	@Autowired
	SchedulePageService service;

	@RequestMapping(method= RequestMethod.GET)
	public String getViewSchedule(ModelMap modelMap, HttpSession session) {
		if (session == null) {
			return "index";
		} else {
			List<Game> list = service.getGames((User)session.getAttribute("user"), (League)session.getAttribute("league"));
			Collections.sort(list);
			modelMap.addAttribute("allGames", list);
			return "ViewSchedulePage";
		}
	}
	
}
