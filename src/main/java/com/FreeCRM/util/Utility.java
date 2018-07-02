package com.FreeCRM.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.FreeCRM.base.TestBase;

public class Utility extends TestBase{

	 String path="C:\\Users\\lenovo\\Desktop\\CRMTestData.xlsx";
	 FileInputStream fis;
	 Workbook workbook;
	 Sheet sheet;
	public static void scrollIntoView(WebElement element) {
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true)",element);
	}
	
	public static WebElement swithFrame(String name,String xpath)
	{
		driver.switchTo().frame(name);
		return driver.findElement(By.xpath(xpath));
	}
	public static void swithToDefaultFrame() {
		
		driver.switchTo().defaultContent();
		
	}
	
	public static boolean clickOnAlert(boolean alert)
	{
		if(alert) {
		try {
		driver.findElement(By.xpath("//span[div[@class='intercom-borderless-dismiss-button']]")).click();
		return true;
		}
		catch(Exception e)
		{
		
			return false;
		}
		}
		return alert;
	}
	
	
	public  Object[][] getTestData(String sheetname) {
		
		try {
			fis=new FileInputStream(path);
			workbook=WorkbookFactory.create(fis);
			sheet=workbook.getSheet(sheetname);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Object[][] data=new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		
		for(int i=0;i<sheet.getLastRowNum();i++)
		{
			for(int j=0;j<sheet.getRow(0).getLastCellNum();j++)
			{
				data[i][j]=sheet.getRow(i+1).getCell(j).toString();
			}
		}
		
		 return data;
	}
	
	public Object[] getTestData(String sheetname,int num) {
		
		try {
		fis=new FileInputStream(path);
		workbook=WorkbookFactory.create(fis);
		sheet=workbook.getSheet(sheetname);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		Object[] data=new Object[sheet.getLastRowNum()];
		
		for(int i=0;i<sheet.getLastRowNum();i++)
		{
			data[i]=sheet.getRow(i+1).getCell(0).toString();
		}
		
		
		return data;
	}
	
}
