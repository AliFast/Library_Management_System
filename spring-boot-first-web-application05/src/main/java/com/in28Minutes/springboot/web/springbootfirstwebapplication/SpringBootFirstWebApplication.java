package com.in28Minutes.springboot.web.springbootfirstwebapplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
 Spring boot is built on top of Spring, this annotation initializes spring framework (Component Scan) 
 first then initializes Spring Boot (Auto Configuration).
 
  application.properties is like a configuration file for this application.
  if you want to run the application on a different port other than default we
  can provide configuration of this in that file.
  
  Now if we run the application as java application it will automatically start the spring framework
  and tomcat using some port. normally its localhost:8080.
  
  if we now type localhost:8080/login on our browser we will see a WhiteLabel Error Page.
  As we have not either created or mapped a login and error page in our application and spring framework
  will show its default error page.
  
  now lets create a controller class. As soon as we created a class or changed anything for example
  write a function server automatically restarts that is because of developer tools dependency that we added in
  pom.xml file. Saves the hastle of restarting server again and again.
  
  
  When we type the url and press enter a Request is sent by the browser to that url and a Response is received.
  you can confirm it from Inspect Element of browser with Network Monitor tab. and you can study about request 
  and response cycle from javatpoint.
 * 
 */
@SpringBootApplication
public class SpringBootFirstWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootFirstWebApplication.class, args);
	}

}
