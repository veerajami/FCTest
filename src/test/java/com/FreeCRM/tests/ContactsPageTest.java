package com.FreeCRM.tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.FreeCRM.base.TestBase;
import com.FreeCRM.pages.ContactsPage;
import com.FreeCRM.pages.HomePage;
import com.FreeCRM.pages.LoginPage;
import com.FreeCRM.util.Utility;

public class ContactsPageTest extends TestBase{

	public LoginPage loginpage;
	public HomePage homepage;
	public ContactsPage contactspage;
	public String sheetname="Name";
	
	public ContactsPageTest()
	{
		super();
	}
	
	@BeforeTest
	public void setup() {
		
		initialize();
		loginpage=new LoginPage();
		Utility.clickOnAlert(alert_message);
		homepage=loginpage.login();
		contactspage=homepage.navigateToContacts();
		
	}
	
	@DataProvider
	public Object[][] testData()
	{
		return new Utility().getTestData(sheetname);
	}
	
	@Test(dataProvider="testData")
	public void validateName(String name) {
		contactspage.setName(name);
	}
	
}







/*@DataProvider
public Object[] testData() {
	
	return new Utility().getTestData(sheetname, 1);
	
}

@Test(dataProvider="testData")
public void validateName(String name) {
	contactspage.setName(name);
}
*/
