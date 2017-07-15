package com.revature.controllers;

import java.util.Map;

import javax.persistence.Entity;
import javax.servlet.http.HttpSession;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.revature.beans.Game;
import com.revature.daos.GameDAO;
import com.revature.daos.GameDAOImpl;

@Entity
@RequestMapping(path="/enterscores")
public class EnterScoresController {
	
	@RequestMapping(method = RequestMethod.GET)
	public String getScoresPage(@RequestParam Map<String, String> gameMap, ModelMap modelMap, HttpSession session) {
		GameDAO dao = new GameDAOImpl();
		Game game = dao.selectGameById(Integer.parseInt((String)gameMap.get("gameId")));
		modelMap.addAttribute("game", game);
		return "EnterScoresPage";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String enterScores(@RequestBody Map<String, Integer> scoresMap, ModelMap modelMap, HttpSession session) {
		GameDAO dao = new GameDAOImpl();
		System.out.println(scoresMap.get("home"));
		System.out.println(scoresMap.get("away"));
		System.out.println(scoresMap.get("id"));
		
		return "viewschedule";
	}

}
