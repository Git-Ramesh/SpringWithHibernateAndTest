package com.rs.dao;

import org.springframework.stereotype.Repository;

@Repository(value="loginDAO")
public class LoginDAOImpl implements LoginDAO {

	
	@Override
	public int checkLogin(String username, String password) {
		System.out.println(username+" "+password);
		if(username.equals("Ramesh")&&password.equals("1234")) {
			return 1;
		}
		return 0;
	}

}
