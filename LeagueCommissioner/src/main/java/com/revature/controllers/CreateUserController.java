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
import com.revature.daos.UserDAO;
import com.revature.daos.UserDAOImpl;

@Controller
@RequestMapping(value = "/createuser")
public class CreateUserController {
	
	@Autowired
	User tempUser;
	
	@RequestMapping(method = RequestMethod.GET)
	public String getHomePage(ModelMap modelMap) {
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
		
		user.setActive(1);
		dao.createUser(user);
		
		return "home";
	}

}
