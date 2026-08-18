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

import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;

import comcomcast.crm.genericutility.webdriverutility.Webdriverutility;

public class CreateOrganizationWithPhoneNumberTest {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		//read the data from properties file
				FileUtility flib=new FileUtility();
				String Browser=flib.getDatFromPropertiesfile("browser");
				String URL=flib.getDatFromPropertiesfile("url");
				String Username=flib.getDatFromPropertiesfile("username");
				String Password=flib.getDatFromPropertiesfile("password");
		// generate random number
			Random random=new Random();
			int randomdata=random.nextInt(1000);
		//read the data from excel
			ExcelUtility elib=new ExcelUtility();
		    String orgName=elib.getDataFromExcel("org", 7, 2)+randomdata;
		    String phno=elib.getDataFromExcel("org", 7, 3);
		     
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
		Webdriverutility wdlib=new Webdriverutility();
		wdlib.waitForPageToLoad(driver);
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
		driver.findElement(By.name("phone")).sendKeys(phno);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		Thread.sleep(2000);
		String actPhno=driver.findElement(By.id("dtlview_Phone")).getText();
		if(actPhno.contains(phno))
		{
			System.out.println(phno+ " header is verified--Pass");
		}
		else {
			System.out.println(phno+ " header is not verified--fail");
		}
         
	   WebElement profileicon = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		wdlib.mousemoveOnelement(driver, profileicon);
		Thread.sleep(2000);
		driver.findElement(By.linkText("Sign Out")).click();
		driver.quit();
	}

}
