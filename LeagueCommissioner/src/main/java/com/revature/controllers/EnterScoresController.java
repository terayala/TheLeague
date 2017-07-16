package com.revature.controllers;

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
import com.revature.beans.Stats;
import com.revature.beans.User;
import com.revature.daos.GameDAO;
import com.revature.daos.GameDAOImpl;
import com.revature.daos.StatsDAO;
import com.revature.daos.StatsDAOImpl;
import com.revature.daos.UserDAO;
import com.revature.daos.UserDAOImpl;
import com.revature.services.SchedulePageService;

@Controller
@RequestMapping(path="/enterscores")
public class EnterScoresController {
	
	@Autowired
	SchedulePageService service;
	
	@RequestMapping(method = RequestMethod.GET)
	public String getScoresPage(@RequestParam Map<String, String> gameMap, ModelMap modelMap, HttpSession session) {
		GameDAO gameDAO = new GameDAOImpl();
		Game game = gameDAO.selectGameById(Integer.parseInt((String)gameMap.get("gameId")));
		modelMap.addAttribute("game", game);
		UserDAO userDAO = new UserDAOImpl();
		List<User> list = userDAO.selectUsersByTeam(((User)session.getAttribute("user")).getTeam().getTeamID());
		modelMap.addAttribute("allPlayers", list);
		return "enterscores";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String enterScores(@RequestParam Map<String, Object> scoresMap, ModelMap modelMap, HttpSession session) {
		StatsDAO statDAO = new StatsDAOImpl(); UserDAO userDAO = new UserDAOImpl(); GameDAO gameDAO = new GameDAOImpl();
		Game game = gameDAO.selectGameById(Integer.parseInt((String)scoresMap.get("id")));
		game.setHomeScore(Integer.parseInt((String)scoresMap.get("home")));
		game.setAwayScore(Integer.parseInt((String)scoresMap.get("away")));
		gameDAO.updateGame(game);
		List<User> list = userDAO.selectUsersByTeam(((User)session.getAttribute("user")).getTeam().getTeamID());
		for (User u : list) {
			statDAO.createStat(new Stats(game, u, Integer.parseInt((String)scoresMap.get(u.getUsername()))));
		}
		List<Game> gameList = service.getGames((User)session.getAttribute("user"), (League)session.getAttribute("league"));
		modelMap.addAttribute("allGames", gameList);
		return "ViewSchedulePage2";
	}

}
