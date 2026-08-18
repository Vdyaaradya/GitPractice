package com.crm.contacttest;

import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;

import comcomcast.crm.genericutility.webdriverutility.Javautility;
import comcomcast.crm.genericutility.webdriverutility.Webdriverutility;

public class CreateContactWithCurrentSystemDate {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
//read the data from properties file
				FileUtility fLib=new FileUtility();
				fLib.getDatFromPropertiesfile("browser");
				String Browser=fLib.getDatFromPropertiesfile("browser");
				String URL=fLib.getDatFromPropertiesfile("url");
		      	String Username=fLib.getDatFromPropertiesfile("username");	
		      	String Password=fLib.getDatFromPropertiesfile("password");
// generate random number
			Javautility jLib=new Javautility();
		    int randomdata	=jLib.getRandomNumber();
//read the data from excel
			ExcelUtility eLib=new ExcelUtility();
		    String lastname=eLib.getDataFromExcel("contacts", 4, 3)+randomdata;
		   		     
		     WebDriver	driver =null;
				
				if(Browser.equals("chrome"))
				{
					driver=new ChromeDriver();
				}
				else if (Browser.equals("firefox")) {
					driver=new FirefoxDriver();
				}
				else if (Browser.equals("edge")) {
					driver=new EdgeDriver();
					
				}
			
		driver.manage().window().maximize();
      Webdriverutility wdLib=new Webdriverutility();
      wdLib.waitForPageToLoad(driver);

		driver.get(URL);
		Thread.sleep(3000);
		driver.findElement(By.name("user_name")).sendKeys(Username);
		
		driver.findElement(By.name("user_password")).sendKeys(Password);
		
		driver.findElement(By.id("submitButton")).click();
		Thread.sleep(2000);
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		Thread.sleep(2000);
	// current and after dates
		
				String startDate=jLib.getSystemDateYYYYMMDD();
				String endDate=jLib.getRequiredDateYYYYDDMM(30);
				System.out.println("START DATE = " + startDate);
				System.out.println("END DATE   = " + endDate);
		

		driver.findElement(By.name("lastname")).sendKeys(lastname);
		driver.findElement(By.name("support_start_date")).clear();
		driver.findElement(By.name("support_start_date")).sendKeys(startDate);
		driver.findElement(By.name("support_end_date")).clear();
		driver.findElement(By.name("support_end_date")).sendKeys(endDate);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		Thread.sleep(2000);
		String actstartadate=driver.findElement(By.id("mouseArea_Support Start Date")).getText();
		if(actstartadate.contains(startDate))
		{
			System.out.println(startDate+ " header is verified--Pass");
		}
		else {
			System.out.println(startDate+ " header is not verified--fail");
		}
		String actafterDate=driver.findElement(By.id("mouseArea_Support End Date")).getText();
		if(actafterDate.equals(endDate))
		{
			System.out.println(endDate+ " info is verified--Pass");
		}
		else {
			System.out.println(endDate+ " info is not verified--fail");
		}

		WebElement profileicon=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		wdLib.mousemoveOnelement(driver, profileicon);
		
		Thread.sleep(2000);
		driver.findElement(By.linkText("Sign Out")).click();
		driver.quit();

	}

}
