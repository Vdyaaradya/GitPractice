package co.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInfoPage {

	
	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement headermessage;
	

	
	WebDriver driver;
	public OrganizationInfoPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public WebElement getHeadermessage() {
		return headermessage;
	}
	
	

	
}
