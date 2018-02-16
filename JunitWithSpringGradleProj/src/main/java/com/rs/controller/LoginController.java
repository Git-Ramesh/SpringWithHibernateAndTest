package com.rs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.rs.command.LoginCommand;
import com.rs.service.LoginService;

@Controller("loginController")
public class LoginController {
	public LoginController() {
		System.out.println("LoginController: 0-param constr");
	}
	private LoginService loginService;
	
	@Autowired
	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}
	
	@RequestMapping(name="/login.htm",method=RequestMethod.GET)
	public String launchLoginPage() {
		return "login";
	}
	@RequestMapping(name="/login.htm",method=RequestMethod.POST)
	public String processLoginPage(ModelMap map , @ModelAttribute("loginCmd")LoginCommand cmd) {
		String status=null;
		
		status=loginService.verifyLogin(cmd.getUsername(), cmd.getPassword());
		map.addAttribute("status", status);
		
		return "login";
	}
}