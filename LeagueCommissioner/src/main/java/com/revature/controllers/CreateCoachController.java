package com.revature.controllers;
/*
package com.revature.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//import com.revature.bean.User;
import com.revature.beans.Team;

@Controller
@RequestMapping(value="/createcoach")
public class CreateCoach {
	
	@Autowired
	Team teamID;
	
	@Autowired
	String firstName;
	
	@Autowired
	String lastName;
	
	@Autowired
	Integer role;
	
	@Autowired
	String email;
	
	@Autowired
	String username;
	
	@Autowired
	String password;
	
	@Autowired
	Integer uniform;
	
	@Autowired
	Integer active;
	
	
	/*public User(Team teamID, String firstName, String lastName, int role, String email, String username, String password,
			int uniform, int active)
	*/
	
	//@RequestMapping(method= RequestMethod.GET)
	//public String getLoginPage(ModelMap modelmap) {
		//System.out.println(modelmap.get("Some info"));
		//System.out.println("GET REQUEST");
	//	modelmap.addAttribute("teamID", teamID);
	//	modelmap.addAttribute("firstName", firstName);
	//	modelmap.addAttribute("lastName", lastName);
	//	modelmap.addAttribute("role", role);
	//	modelmap.addAttribute("email", email);
	//	modelmap.addAttribute("username", username);
	//	modelmap.addAttribute("password", password);
	//	modelmap.addAttribute("uniform", uniform);
	//	modelmap.addAttribute("active", active);
		
	//	return "createcoach";
		
	//}
	
	
	//@RequestMapping(method= RequestMethod.POST)
	//public String doCreateCoach(BindingResult bindingResult, ModelMap modelMap, HttpSession session) {
		
		/*
		 * @Valid
		 * - apply a validation check on user object
		 * -It's at this point it will validate against our validator annotations that
		 * we used in our bean.
		 * 
		 * -BindingResult, this object houses error message, should any of the validation checks come back
		 * as a failure
		 * 
		 * -ModelMap- this object represents the data being passed around the backend, and will ultimately
		 * be passes back to the client at the end of the lifecycle displayed through a view
		 * 
		 * -HttpSession- this is the session object
		 */
		
	//	if(bindingResult.hasErrors()) {
	//		return "createcoach";
	//	}
		
		//User authUser = userService.auth(user);
		
		//if(authUser != null) {
			//System.out.println(user.getUsername());
		//	System.out.println("POST REQUEST");
			//modelMap.addAttribute("user", user); //request scope
			//session.setAttribute("alsoUser", user); //session scope
		//	return "home";
		//}
		//else {
			//modelMap.addAttribute("errorMessgage", "username/password incorrect");
			//return "login";
		//}

//	}

//}
