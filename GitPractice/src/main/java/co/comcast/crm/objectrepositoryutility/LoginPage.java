package co.comcast.crm.objectrepositoryutility;

import java.sql.Driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {           //R1-create  separate POM class
 @FindBy(name = "user_name")       //R2-object creation
 private WebElement usernameEdit;
 
 @FindBy(name = "user_password")
  private WebElement passwordEdit;
 //@FindBys({@FindBy(id = "submitbutton"), @FindBy(xpath="//input[@type='submit']")}) //noSuchElementException
 @FindAll({@FindBy(id = "submitButton"),@FindBy(xpath = "//input[@type='Submit']")})
 private WebElement login;
 
 //object initialization
 WebDriver driver;
 public LoginPage(WebDriver driver)
 {
	 this.driver=driver;
	 PageFactory.initElements(driver, this);
 }
//R4-object Encapsulation
 public WebElement getUsernameEdit() {
	return usernameEdit;
 }
 public WebElement getPasswordEdit() {
	return passwordEdit;
 }

 public WebElement getLogin() {
	return login;
 }

 
//R5- object utilization by multiple element via business actions
 public void loginToApp(String username,String password)
 {
	driver.manage().window().maximize();
	usernameEdit.sendKeys(username);
	passwordEdit.sendKeys(password);
	login.click();
	
}
 
}
