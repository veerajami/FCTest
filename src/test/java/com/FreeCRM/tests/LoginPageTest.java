package com.FreeCRM.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.FreeCRM.base.TestBase;
import com.FreeCRM.pages.HomePage;
import com.FreeCRM.pages.LoginPage;

public class LoginPageTest extends TestBase{

	LoginPage loginpage;
	HomePage homepage;
	public LoginPageTest() {
		
		super();
	}
	
	@BeforeMethod
	public void setup() {
		initialize();
		loginpage=new LoginPage();
	}
	
	@Test
	public void logintest() {
		homepage=loginpage.login();
		Assert.assertTrue(homepage.validate);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
}
