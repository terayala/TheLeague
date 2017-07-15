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
import com.revature.beans.User;
import com.revature.daos.GameDAO;
import com.revature.daos.GameDAOImpl;
import com.revature.services.SchedulePageService;

@Controller
@RequestMapping(path="/enterscores")
public class EnterScoresController {
	
	@Autowired
	SchedulePageService service;
	
	@RequestMapping(method = RequestMethod.GET)
	public String getScoresPage(@RequestParam Map<String, String> gameMap, ModelMap modelMap, HttpSession session) {
		GameDAO dao = new GameDAOImpl();
		Game game = dao.selectGameById(Integer.parseInt((String)gameMap.get("gameId")));
		modelMap.addAttribute("game", game);
		return "enterscores";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String enterScores(@RequestParam Map<String, Object> scoresMap, ModelMap modelMap, HttpSession session) {
		GameDAO dao = new GameDAOImpl();
		Game game = dao.selectGameById(Integer.parseInt((String)scoresMap.get("id")));
		game.setHomeScore(Integer.parseInt((String)scoresMap.get("home")));
		game.setAwayScore(Integer.parseInt((String)scoresMap.get("away")));
		dao.updateGame(game);
		List<Game> list = service.getGames((User)session.getAttribute("user"), (League)session.getAttribute("league"));
		modelMap.addAttribute("allGames", list);
		return "ViewSchedulePage";
	}

}
