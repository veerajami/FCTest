package com.FreeCRM.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.FreeCRM.base.TestBase;

public class ContactsPage extends TestBase{

	@FindBy(xpath="//input[@name='cs_name']")
	public WebElement name_textbox;
	
	public ContactsPage() {
		driver.switchTo().frame(frame);
		PageFactory.initElements(driver, this);
	}
	
	public void setName(String str)
	{
		name_textbox.sendKeys(str);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		name_textbox.clear();
	}
	
	
}
