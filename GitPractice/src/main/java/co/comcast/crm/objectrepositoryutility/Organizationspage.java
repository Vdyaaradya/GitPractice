package co.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Organizationspage{

	@FindBy(xpath = "//img[@title='Create Organization...']")
	private WebElement createOrganization;

@FindBy(name = "search_text")	
private WebElement searchOrgName;

@FindBy(name = "submit")	
private WebElement searchNow;

	public WebElement getSearchNow() {
	return searchNow;
}
	public WebElement getSearchOrgName() {
	return searchOrgName;
}
	
	@FindBy(name = "search_field")
	private WebElement organizationNameDropdown;
	
	public WebElement getOrganizationNameDropdown() {
		return organizationNameDropdown;
	}

	WebDriver driver;
public   Organizationspage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public WebElement getCreateOrganization() {
		return createOrganization;
	}

	}
	

