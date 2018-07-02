package com.FreeCRM.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.FreeCRM.base.TestBase;

public class LoginPage extends TestBase{

	@FindBy(xpath="//*[@id='loginForm']/div/input[1]")
	public static WebElement username_textbox;
	
	@FindBy(xpath=".//*[@id='loginForm']/div/input[2]")
	public static WebElement password_textbox;
	
	@FindBy(xpath="//input[@type='submit']")
	public static WebElement login_button;
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	public HomePage login() {
		username_textbox.sendKeys("vinjami");
		password_textbox.sendKeys("freecrm$1992");
		login_button.click();
		
		return new HomePage();
	}
}
