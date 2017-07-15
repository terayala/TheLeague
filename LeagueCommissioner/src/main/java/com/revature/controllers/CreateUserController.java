package com.revature.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.revature.beans.League;
import com.revature.beans.Team;
import com.revature.beans.User;
import com.revature.daos.TeamDAOImpl;
import com.revature.daos.UserDAO;
import com.revature.daos.UserDAOImpl;

@Controller
@RequestMapping(value = "/createuser")
public class CreateUserController {
	
	@Autowired
	User tempUser;
	
	@RequestMapping(method = RequestMethod.GET)
	public String getHomePage(ModelMap modelMap, HttpSession session) {
		User user = (User)session.getAttribute("user");
		if(user.getRole() == 3) {
			List<Team> teams = new TeamDAOImpl().selectTeamsByLeague(((League)session.getAttribute("league")).getLeagueID());
			modelMap.addAttribute("teams", teams);
		}
		modelMap.addAttribute("user", tempUser);
		return "CreateUserPage";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String doCreateUser(@Valid User user, BindingResult bindingResult, ModelMap modelMap, HttpSession session) {
		if (bindingResult.hasErrors()) {
			return "createuser";
		}
		
		UserDAO dao =  new UserDAOImpl();
		user.setActive(1);
		if(((User)session.getAttribute("user")).getRole()==2){
			user.setRole(1);
			user.setTeam(((User)session.getAttribute("user")).getTeam());
		}
		else {
			user.setRole(2);
		}
		dao.createUser(user);
		
		return "home";
	}

}
