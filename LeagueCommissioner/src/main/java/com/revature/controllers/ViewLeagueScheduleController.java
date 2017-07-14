package com.revature.controllers;

import java.sql.Timestamp;
import java.util.ArrayList;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.revature.beans.Game;
import com.revature.beans.Team;
import com.revature.services.LeagueScheduleService;

@Controller
@RequestMapping(value = "/viewleagueschedule")
public class ViewLeagueScheduleController {

	@Autowired
	LeagueScheduleService leagueScheduleService;
	
	@Autowired
	Game game;
	
	@Autowired 
	Team team;
	
	/*
	@RequestMapping(method = RequestMethod.POST)
	public String doViewLeagueSchedule(@Valid Team team, BindingResult bindingResult, ModelMap modelMap, HttpSession session) {

		if (bindingResult.hasErrors()) {
			return "viewleagueschedule";
		}
		
		
		ArrayList<Game> gameList= new ArrayList<>();
		ArrayList<Integer> teams= new ArrayList<>();
		ArrayList<Timestamp> dates= new ArrayList<>();
		
		// generate league schedule based on an ArrayList of teams and dates
		gameList=leagueScheduleService.MakeSchedule(teams, dates);
		//TeamDAO dao = new TeamDAOImpl();
		//team.setLeague((League) session.getAttribute("league"));
		//dao.createTeam(team);
		//session.setAttribute("TeamDAOImpl", dao.getAllTeams());
		
		return "viewleagueschedule";
	}
	*/
	@RequestMapping(method = RequestMethod.GET)
	public String getViewLeagueSchedulePage(ModelMap modelMap){
		
		//ArrayList<Game> gameList= new ArrayList<>();
		//ArrayList<Integer> teams= new ArrayList<>();
		//ArrayList<Timestamp> dates= new ArrayList<>();
		
		// generate league schedule based on an ArrayList of teams and dates
		//gameList=leagueScheduleService.MakeSchedule(teams, dates);
		//modelMap.addAttribute("schedule", gameList);
		return "viewleagueschedule";
	}
}
