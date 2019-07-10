package com.in28Minutes.springboot.web.springbootfirstwebapplication.service;

import org.springframework.stereotype.Component;


// to make this class a spring bean so that spring framework can manage instances of this class
@Component
public class LoginService {

	public boolean validateUser(String username,String password) {
		//validate username = ali and password = dummy
		return username.equalsIgnoreCase("ali") && password.equalsIgnoreCase("dummy");
	}
}
