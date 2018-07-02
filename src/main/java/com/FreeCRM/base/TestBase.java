package com.FreeCRM.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.FreeCRM.util.WebEventListener;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	public static FileInputStream fis;
	public String browser;
	public static WebEventListener welistener;
	public static EventFiringWebDriver efwdriver;
	public static boolean alert_message=true;
	public String frame="mainpanel";
	
	public TestBase() {
		
		try {
			 fis=new FileInputStream("D:\\java\\New Eclipse\\FreeCRMAutomationTest\\src\\main\\java\\com\\FreeCRM\\config\\config.properties");
			 prop=new Properties();
			prop.load(fis);
		} catch (IOException e) {
			
			System.out.println("Error: with config file");
		}
		
		
	}
	
	public void initialize() {
		browser=prop.getProperty("browser");
		if(browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", prop.getProperty("chrome_path"));
			driver=new ChromeDriver();
		}
		else if(browser.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", prop.getProperty("firfox_path"));
			driver=new FirefoxDriver();
		}
			
		efwdriver=new EventFiringWebDriver(driver);
		welistener=new WebEventListener();
		efwdriver.register(welistener);
		driver=efwdriver;
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.get(prop.getProperty("url"));
			
	}
	
	
}
