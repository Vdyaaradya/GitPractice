package com.crm.orgtest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
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

import co.comcast.crm.objectrepositoryutility.CraeteNewOrganizationpage;
import co.comcast.crm.objectrepositoryutility.HomePage;
import co.comcast.crm.objectrepositoryutility.LoginPage;
import co.comcast.crm.objectrepositoryutility.OrganizationInfoPage;
import co.comcast.crm.objectrepositoryutility.Organizationspage;
import comcomcast.crm.genericutility.webdriverutility.Javautility;
import comcomcast.crm.genericutility.webdriverutility.Webdriverutility;

public class CreateOrganizationTest {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
//read the data from properties file
	FileUtility flib=new FileUtility();
	String Browser	=flib.getDatFromPropertiesfile("browser");
	String URL=	flib.getDatFromPropertiesfile("url");
	String Username=flib.getDatFromPropertiesfile("username");
	String Password=flib.getDatFromPropertiesfile("password");
// generate random number
	Javautility jLib=new Javautility();
	int randomdata=jLib.getRandomNumber();
//read the data from excel
	ExcelUtility eLib=new ExcelUtility();
	String organizationName=eLib.getDataFromExcel("org", 1, 2)+randomdata;
				
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

		Webdriverutility wdlib=new Webdriverutility();
		wdlib.waitForPageToLoad(driver);
		driver.get(URL);
		Thread.sleep(3000);
		
		LoginPage lp=new LoginPage(driver);
		lp.loginToApp(Username, Password);
		HomePage hp=new HomePage(driver);
		hp.getOrgLink().click();
		Organizationspage op=new Organizationspage(driver);
		op.getCreateOrganization().click();
		CraeteNewOrganizationpage cnop=new CraeteNewOrganizationpage(driver);
        cnop.createorgname(organizationName);
       OrganizationInfoPage oip=new OrganizationInfoPage(driver);
       String actOrgname= oip.getHeadermessage().getText();
       if(actOrgname.contains(organizationName))
       {
    	   System.out.println(organizationName+ "name is verified--Pass");
       }
       else
       {
    	  System.out.println(organizationName+ "name is not verified---fail"); 
       }
       hp.getOrgLink().click();
       op.getSearchOrgName().sendKeys(organizationName);
       wdlib.selectByVisibleText(op.getOrganizationNameDropdown(), "Organization Name");
       op.getSearchNow().click();
       driver.findElement(By.xpath("//a[text()='"+organizationName+"']/../../td[8]/a[text()='del']")).click();
       wdlib.switchTOAlertToAccept(driver);
       
		/*driver.findElement(By.name("user_name")).sendKeys(Username);
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
		WebElement profileicon=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
	    wdlib.mousemoveOnelement(driver, profileicon);
		Thread.sleep(2000);
		driver.findElement(By.linkText("Sign Out")).click(); */
        hp.logout();
		driver.quit();

	}

}
