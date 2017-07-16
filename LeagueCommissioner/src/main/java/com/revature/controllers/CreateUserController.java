package com.revature.controllers;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.revature.beans.League;
import com.revature.beans.Team;
import com.revature.beans.User;
import com.revature.daos.TeamDAOImpl;
import com.revature.daos.UserDAO;
import com.revature.daos.UserDAOImpl;

@Controller
@RequestMapping(value = "/createuser")
public class CreateUserController {
	
	@RequestMapping(method = RequestMethod.GET)
	public String getHomePage(ModelMap modelMap, HttpSession session) {
		User user = (User)session.getAttribute("user");
		if(user.getRole() == 3) {
			List<Team> teams = new TeamDAOImpl().selectTeamsByLeague(((League)session.getAttribute("league")).getLeagueID());
			modelMap.addAttribute("teams", teams);
		}
		return "CreateUserPage";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String doCreateUser(@RequestParam Map<String, Object> userMap, ModelMap modelMap, HttpSession session) {
		UserDAO dao =  new UserDAOImpl();
		String fname = (String) userMap.get("firstName");
		String lname = (String) userMap.get("lastName");
		String email = (String) userMap.get("email");
		String username = (String) userMap.get("username");
		String pwd = (String) userMap.get("password");
		if(((User)session.getAttribute("user")).getRole()==2){
			// player
			int uniform = Integer.parseInt( (String) userMap.get("uniform") );
			dao.createUser(new User(((User)session.getAttribute("user")).getTeam(), fname, lname, 1, email, username, pwd, uniform, 1));
		}
		else {
			Team team = new TeamDAOImpl().selectTeamById( Integer.parseInt( (String) userMap.get("team") ) );
			dao.createUser(new User(team, fname, lname, 1, email, username, pwd, 1));
		}
		return "home";
	}

}
