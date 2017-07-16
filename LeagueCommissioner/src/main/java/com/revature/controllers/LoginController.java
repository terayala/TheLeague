package com.revature.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.revature.beans.User;
import com.revature.services.LeagueService;
import com.revature.services.UserService;

@Controller
@RequestMapping(value = "/login")
public class LoginController {
	@Autowired
	User userTemplate;
	
	@Autowired
	UserService userService;
	
	@Autowired
	LeagueService leagueService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String getLoginPage(ModelMap modelMap) {
		userTemplate.setFirstName("firstname");
		userTemplate.setLastName("lastname");
		userTemplate.setEmail("email@email.com");
		modelMap.addAttribute("user", userTemplate);
		return "login";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String doLogin(@Valid User user, 
								BindingResult bindingResult, 
								ModelMap modelMap, 
								HttpSession session) {
		
		// If user's username and/or password is empty.
		if(bindingResult.hasErrors()) {
			System.out.println("BindingResult.HasErrors Triggered (return login)");
			return "login";
		}
		
		// Check user's username and password with the database.
		User authUser = userService.auth(user);
		
		/*
		 * If credentials pass:
		 * 	If role is commissioner:
		 * 		Preset league to null and grab all leagues.
		 * 	Otherwise:
		 * 		Grab player or coach's league.
		 * 	Go to home page.
		 */
		if(authUser != null) {
			session.setAttribute("user", authUser);
			if(authUser.getRole() == 3) {
				session.setAttribute("league", null);
				modelMap.addAttribute("allLeagues", leagueService.getAllLeagues());
			} else {
				session.setAttribute("league", authUser.getTeam().getLeague());
			}
			return "home";
		} else {
			modelMap.addAttribute("errorMessage", "Username and/or password is incorrect");
			return "login";
		}
	}
}
