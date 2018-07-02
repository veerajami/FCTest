package com.FreeCRM.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.FreeCRM.base.TestBase;
import com.FreeCRM.util.Utility;

public class HomePage extends TestBase{
	
	
	public boolean validate;

	
/*	@FindBy(xpath="//td[@class='headertext'][contains(text(),'User')]")
	public static WebElement user_name;
	*/
/*	@FindBy(xpath="//*[@id='rh_footer']/div[3]/div/div/div[2]/div[4]/span[2]")
	WebElement copyright;*/
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	public boolean validateLogoText() {
		
		WebElement logo_text=Utility.swithFrame(frame, "//td[text()='CRMPRO']");
		boolean value=logo_text.isDisplayed();
		Utility.swithToDefaultFrame();
		return value;
		
	}
	
	public boolean validateUserName() {
		
		WebElement logo_text=Utility.swithFrame(frame, "//td[@class='headertext'][contains(text(),'User')]");
		boolean value=logo_text.isDisplayed();
		WebElement user_name=driver.findElement(By.xpath("//td[@class='headertext'][contains(text(),'User')]"));
		validate=user_name.getAttribute("innerHTML").contains("vin jami");
		Utility.swithToDefaultFrame();
		
		return value;
	}
	
	
	public ContactsPage navigateToContacts() {
		
		Utility.swithFrame(frame, "//a[text()='Contacts']").click();
		Utility.swithToDefaultFrame();
		
		return new ContactsPage();
	}

}
