package com.in28Minutes.springboot.web.springbootfirstwebapplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.in28Minutes.springboot.web.springbootfirstwebapplication.service.LoginService;


@Controller
public class LoginController {

	/*
	 * in Step 08 we want to make use of the password field and add 
	 * hard coded verification of username and password with an invalid credential 
	 * message. 
	 * 
	 * For adding verification we add a LoginService class in Service package
	 * to provide us the verification service.
	 * 
	 * If we were not using Spring/Spring Boot Framework we would have to initialize the loginService
	 * object using new keyword. In Spring we can use dependency Injection for this purpose.
	 * 
	 * dependency means one class is dependent upon other class/classes and cannot function properly
	 * without it. Since LoginController is dependent upon LoginService we need LoginService object
	 * which we can inject using some annotations.
	 * 
	 * What we do is that we make LoginService class a Spring Bean using @Componenet annotation.
	 * By using this Spring will manage the creation of instances of this class and we will not need to
	 * worry about it.
	 * 
	 *   next we add @Autowired annotation at places where we need objects of LoginService class.
	 *   This annotation / dependency injection framework will ask spring to give it the instance of LoginService 
	 *   class it has created.
	 *   
	 *   without this we will get a Null object exception
	 *   
	 *   we can make LoginService an Interface and design it so that we don't need to
	 *   change this class for any changes is that Service.
	 *   
	 * 
	 */

	@Autowired
	LoginService loginService;
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String showloginPage(ModelMap model) {

		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String showWelcomePage(@RequestParam String name,@RequestParam String password, ModelMap model) {
		
		if(!loginService.validateUser(name, password)) {
			model.put("errorMessage","Invalid Credentials");
			return "login";
		}
		
		model.put("name", name);
		
		return "welcome";
	}

}
