package com.FreeCRM.tests;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.FreeCRM.base.TestBase;
import com.FreeCRM.pages.HomePage;
import com.FreeCRM.pages.LoginPage;

public class HomePageTest extends TestBase{

	public HomePageTest() {
		super();
	}
	LoginPage loginpage; 
	HomePage homepage;
	Logger log=Logger.getLogger(HomePageTest.class);
    
	@BeforeMethod
	public void setup() {
		initialize();
		log.info("*********************************Before Method statring *********************");
		loginpage=new LoginPage();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		homepage=loginpage.login();
		
		log.info("*********************************Before Method Ending *********************");

	}
	
	@Test
	public void validateLogoText() {
		log.info("*********************************validateLogoText Method Starting *********************");

		Assert.assertTrue(homepage.validateLogoText());
		
		log.info("*********************************validateLogoText Method Ending *********************");

		}
	
	@Test()
	public void validateUserNameTest() {
		log.info("*********************************validateUserNameTest Method Ending *********************");

		Assert.assertTrue(homepage.validateUserName());
		log.info("*********************************validateUserNameTest Method Ending *********************");

	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	

}
