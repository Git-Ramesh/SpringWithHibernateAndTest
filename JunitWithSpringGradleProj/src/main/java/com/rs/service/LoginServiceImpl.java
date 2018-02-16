package com.rs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rs.dao.LoginDAO;

@Service("loginService")
public class LoginServiceImpl implements LoginService{
	
	private LoginDAO loginDAO;

	@Autowired
	public void setLoginDAO(LoginDAO loginDAO) {
		this.loginDAO=loginDAO;
	}
	
	@Override
	public String verifyLogin(String username, String password) {
		System.out.println("Service:: "+username+" "+password+" "+loginDAO.getClass());
		String status="Login Failed";
		int count=0;
		
		if(username==null || password==null||username.trim().length()==0||password.trim().length()==0)
			throw new IllegalArgumentException("Please provide credentials");
		count=loginDAO.checkLogin(username, password);
		if(count>0)
			status="Login Successful";
		
		return status;
	}
}