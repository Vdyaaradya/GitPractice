package com.crm.orgtest;

import java.io.FileInputStream;
import java.time.Duration;
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
import org.openqa.selenium.support.ui.Select;

import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;

import comcomcast.crm.genericutility.webdriverutility.Javautility;
import comcomcast.crm.genericutility.webdriverutility.Webdriverutility;

public class CreateOrganizationWithIndustryTest2 {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		//read the data from properties file
		FileUtility flib=new FileUtility();
		flib.getDatFromPropertiesfile("browser");
			   String Browser=flib.getDatFromPropertiesfile("browser");
				String URL=flib.getDatFromPropertiesfile("url");
				String Username=flib.getDatFromPropertiesfile("username");
				String Password=flib.getDatFromPropertiesfile("password");
		// generate random number
			Javautility jLib=new Javautility();
			int randomdata=jLib.getRandomNumber();
		//read the data from excel
			ExcelUtility elib=new ExcelUtility();
			elib.getDataFromExcel("org", 1, 2);
	        String orgName=elib.getDataFromExcel("org", 1, 2)+randomdata;
		    String industry=elib.getDataFromExcel("org", 4, 3);
		    String type=elib.getDataFromExcel("org", 4, 4);
		    System.out.println(industry);
		    System.out.println(type);
		    
		     WebDriver	driver =null;
				
				if(Browser.equals("chrome"))
				{
					driver=new ChromeDriver();
				}
				else if (Browser.equals("firefox")) 
				{
					driver=new FirefoxDriver();
				}
				else if (Browser.equals("edge")) 
				{
					driver=new EdgeDriver();
					
				}
			
		driver.manage().window().maximize();
		Webdriverutility wdLib=new Webdriverutility();
		wdLib.waitForPageToLoad(driver);
		driver.get(URL);
		Thread.sleep(3000);
		driver.findElement(By.name("user_name")).sendKeys(Username);
		Thread.sleep(2000);
		driver.findElement(By.name("user_password")).sendKeys(Password);
		Thread.sleep(3000);
		driver.findElement(By.id("submitButton")).click();
		Thread.sleep(2000);
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		Thread.sleep(2000);
		driver.findElement(By.name("accountname")).sendKeys(orgName);
		WebElement ind=driver.findElement(By.name("industry"));
		Select sel1=new Select(ind);
		sel1.selectByValue(industry);
		Thread.sleep(2000);
		WebElement typedrop=driver.findElement(By.name("accounttype"));
		Select sel2=new Select(typedrop);
		sel2.selectByValue(type);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		Thread.sleep(2000);
	    String actindustry=driver.findElement(By.id("dtlview_Industry")).getText();
	   if(actindustry.equals(industry))
		{
			System.out.println(industry+" info is verified---pass");
		}
		else {
			System.out.println(orgName+" info is  not verified---fail");
		}
	   String acttype=driver.findElement(By.id("dtlview_Type")).getText();
	   if(acttype.equals(industry))
		{
			System.out.println(type+" info is verified---pass");
		}
		else {
			System.out.println(type+" info is  not verified---fail");
		}
       
	   WebElement profileicon=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
	   wdLib.mousemoveOnelement(driver, profileicon);
		Thread.sleep(2000);
		driver.findElement(By.linkText("Sign Out")).click();
		driver.quit();

	}

}
