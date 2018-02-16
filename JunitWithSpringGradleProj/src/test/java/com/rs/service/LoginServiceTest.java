package com.rs.service;


import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.rs.config.RootConfig;
import com.rs.dao.LoginDAO;

import junit.textui.TestRunner;

@RunWith(MockitoJUnitRunner.class)
/*@ContextConfiguration(classes=RootConfig.class)
@RunWith(SpringJUnit4ClassRunner.class)*/
public class LoginServiceTest {
	TestRunner r=null;
	@Mock
	//@Autowired
	private  LoginDAO mockLoginDAO;
	//@Autowired
	 @InjectMocks
	private  LoginServiceImpl loginService;
	
	@BeforeClass
	public static void setUpBeforeClass() {
		
	}
	@AfterClass
	public static void tearDownAfterClass() {
		
	}
	@Before
	public void setUp() {
		
	}
	@After
	public void tearDown() {
		
	}
	
	@Test
	@Ignore
	public void testVerifyLoginWithValidCredentials() {
		Mockito.when(mockLoginDAO.checkLogin("Ramesh","1234")).thenReturn(1);
		String status=null;
		
		status=loginService.verifyLogin("Ramesh","1234");
		System.out.println(status);
		assertTrue(status.contains("Successful"));
	}
	@Test
	@Ignore
	public void testVerifyLoginWithInvalidCredentials() {
		String status=null;
		
		Mockito.when(mockLoginDAO.checkLogin("Ramesh","adsd")).thenReturn(0);
		status=loginService.verifyLogin("Ramesh","adsd");
		System.out.println(status);
		assertFalse("Fatal: accepted invalid credentials",status.contains("Successful"));
	}
	@Test(expected=IllegalArgumentException.class)
	public void testVerifyLoginWithNoCredentails() {
		String status=null;
		
		status=loginService.verifyLogin("","");
		fail("IllegalArgumentException expected but not raised");
	}
}
