package com.crm.contacttest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

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

public class CreateContactwithOrgTest {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
   //read the data from properties file
		FileUtility flib=new FileUtility();
		String Browser=flib.getDatFromPropertiesfile("browser");
	 	String URL=flib.getDatFromPropertiesfile("url");
		String Username=flib.getDatFromPropertiesfile("username");
		String Password=flib.getDatFromPropertiesfile("password");
// generate random number
	Javautility jLib=new Javautility();
	int randomdata=jLib.getRandomNumber();
//read the data from excel

    ExcelUtility eLib=new ExcelUtility();
    String orgName =eLib.getDataFromExcel("contacts", 7, 2)+randomdata;   
    String lastname=eLib.getDataFromExcel("contacts", 7, 3)+randomdata;
		WebDriver driver=null;
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
driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
Thread.sleep(2000);
String headerInfo=driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
if(headerInfo.contains(orgName))
{
	System.out.println(orgName+ " header is verified--Pass");
}
else {
	System.out.println(orgName+ " header is not verified--fail");
}

String actOrgName=driver.findElement(By.id("dtlview_Organization Name")).getText();
if(actOrgName.equals(orgName))
{
	System.out.println(orgName+" info is created---pass");
}
else {
	System.out.println(orgName+" info is  not created---fail");
}
	//creation of contact
Thread.sleep(2000);
driver.findElement(By.linkText("Contacts")).click();
driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
Thread.sleep(2000);
driver.findElement(By.name("lastname")).sendKeys(lastname);
 String parentwindow = driver.getWindowHandle();
driver.findElement(By.xpath("//input[@name='account_name']/following-sibling::img[@src='themes/softed/images/select.gif']")).click();
//switch  window to child window
 wdlib.switchTotabOnUrl(driver, "http://49.249.29.4:8888/index.php?module=Accounts&action=");
 
 /* Set<String> windows = driver.getWindowHandles();
   for(String childwindow: windows)
   {
	 driver.switchTo().window(childwindow);
	 Thread.sleep(3000);
	 if(driver.getCurrentUrl().contains("http://49.249.29.4:8888/index.php?module=Accounts&action="))
	 {
		 driver.findElement(By.name("search_text")).sendKeys(orgName);
		 driver.findElement(By.name("search")).click();
		 Thread.sleep(2000);
		 driver.findElement(By.xpath("//a[text()='"+orgName+"']")).click();
	 }
  }*/
 
 //switch to parent window
 Thread.sleep(2000);
 wdlib.switchTotabOnUrl(driver, parentwindow);
 //driver.switchTo().window(parentwindow);
 Thread.sleep(3000);
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
WebElement profileicon = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
wdlib.mousemoveOnelement(driver, profileicon);
Thread.sleep(2000);
driver.findElement(By.linkText("Sign Out")).click();
driver.quit();

	}

}
