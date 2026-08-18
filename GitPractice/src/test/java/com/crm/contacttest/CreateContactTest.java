package com.crm.contacttest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;

import co.comcast.crm.objectrepositoryutility.LoginPage;
import comcomcast.crm.genericutility.webdriverutility.Javautility;
import comcomcast.crm.genericutility.webdriverutility.Webdriverutility;

public class CreateContactTest {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		

			//read the data from properties file
			FileUtility fLib=new FileUtility();
			String Browser=fLib.getDatFromPropertiesfile("browser");
			String URL=fLib.getDatFromPropertiesfile("url");
			String Username=fLib.getDatFromPropertiesfile("username");
			String Password=fLib.getDatFromPropertiesfile("password");
// generate random number
			Javautility jLib=new Javautility();
			int randomdata=jLib.getRandomNumber();
//read the data from excel
			ExcelUtility eLib=new ExcelUtility();
			String lastname = eLib.getDataFromExcel("contacts",1,3)+randomdata;
			
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
		Webdriverutility wdLib=new Webdriverutility();
		wdLib.waitForPageToLoad(driver);
		driver.get(URL);
		Thread.sleep(3000);
		//object initialization
		LoginPage lp=new LoginPage(driver);
		lp.loginToApp(Username, Password);

		//Thread.sleep(2000);
		/*driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		Thread.sleep(2000);
		driver.findElement(By.name("lastname")).sendKeys(lastname);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		Thread.sleep(2000);
		String lastnameInfo=driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(lastnameInfo.contains(lastname))
		{
			System.out.println(lastname+ " header is verified--Pass");
		}
		else {
			System.out.println(lastname+ " header is not verified--fail");
		}
		String actLastname=driver.findElement(By.id("dtlview_Last Name")).getText();
		if(actLastname.equals(lastname))
		{
			System.out.println(lastname+ " info is verified--Pass");
		}
		else {
			System.out.println(lastname+ " info is not verified--fail");
		     }

		WebElement profileIcon= driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		wdLib.mousemoveOnelement(driver,profileIcon);
		Thread.sleep(2000);
		driver.findElement(By.linkText("Sign Out")).click();*/
		driver.quit();

			}

	

	}


