package com.lovo.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lovo.model.User;
import com.lovo.service.UserService;

@Controller
public class LoginController {
	@Autowired
	private UserService userService;
	
	private static Logger logger = Logger.getLogger(LoginController.class);
	
	@RequestMapping(value="login",method=RequestMethod.POST)
	public String login(@ModelAttribute("user") User user) {	
		logger.debug(user);
		if (userService.login(user.getUsername(), user.getPassword())) {
			return "Success";
		} else {
			return "Login";
		}
	}
}
