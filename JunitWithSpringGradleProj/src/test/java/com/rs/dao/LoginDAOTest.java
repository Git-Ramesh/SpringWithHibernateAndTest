package com.rs.dao;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import com.rs.config.RootConfig;

//@RunWith(SpringJUnit4ClassRunner.class)
@RunWith(SpringRunner.class)
//SpringRunner extends SpringJUnit4ClassRunner
@ContextConfiguration(classes=RootConfig.class)
public class LoginDAOTest {
	private LoginDAO loginDAO;
	
	@Autowired
	@Qualifier("loginDAO")
	public void setLoginDAO(LoginDAO loginDAO) {
		this.loginDAO=loginDAO;
	}
	
	@Test
	public void testCheckLoginWithValidCredentials() {
		int count=0;
		
		count=loginDAO.checkLogin("Ramesh","1234");
		assertEquals(1, count);
	}
	@Test
	public void testCheckLoginWithInValidCredentials() {
		int count=0;
		
		count=loginDAO.checkLogin("Ramesh","1asd");
		assertEquals(0, count);
	}
}