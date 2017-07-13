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
import com.revature.services.UserService;

@Controller
@RequestMapping(value = "/login")
public class LoginController {
	@Autowired
	User userTemplate;
	
	@Autowired
	UserService userService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String getLoginPage(ModelMap modelMap) {
		System.out.println("login GET");
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
		
		System.out.println("login POST");
		System.out.println("username: " + user.getUsername());
		System.out.println("password: " + user.getPassword());
		System.out.println("firstname: " + user.getFirstName());
		System.out.println("lastname: " + user.getLastName());
		System.out.println("email: " + user.getEmail());
		
		// If user's username and/or password is empty.
		if(bindingResult.hasErrors()) {
			System.out.println("BindingResult.HasErrors Triggered (return login)");
			return "login";
		}
		
		// Check user's username and password with the database.
		User authUser = userService.auth(user);
		
		// If credentials pass, go to home page.
		if(authUser != null) {
			session.setAttribute("user", authUser);
			return "home";
		} else {
			modelMap.addAttribute("errorMessage", "Username and/or password is incorrect");
			return "login";
		}
		
	}
}
