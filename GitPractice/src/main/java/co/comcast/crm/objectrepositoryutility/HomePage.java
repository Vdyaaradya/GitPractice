package co.comcast.crm.objectrepositoryutility;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class HomePage{

	@FindBy(linkText = "Organizations")
	 private WebElement orgLink;
	
	public WebElement getMorelink() {
		return morelink;
	}
	@FindBy(linkText = "Contacts")
	 private WebElement contactLink;
	
	@FindBy(linkText = "Products")
	 private WebElement ProductsLink;

	
	@FindBy(linkText = "More")
	 private WebElement morelink;

	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
    private WebElement profileIcon;
	
	@FindBy(linkText = "Sign Out")
    private WebElement signout;

	
	@FindBy(linkText = "Campaigns")
	 private WebElement campaignlink;

	
	WebDriver driver;
	public HomePage(WebDriver driver)
	{
		this.driver=driver; 
		PageFactory.initElements(driver, this);
	}
	public WebElement getCampaignlink() {
		return campaignlink;
	}
	public WebElement getOrgLink() {
		return orgLink;
	}
	public WebElement getContactLink() {
		return contactLink;
	}
	public WebElement getProfileIcon() {
		return profileIcon;
	}
	public WebElement getSignout() {
		return signout;
	}
	public void navigateToCampaignpage()
	{
		Actions act=new Actions(driver);
		act.moveToElement(morelink).perform();
		campaignlink.click();
		
	}

	
	public void logout()
	{
	Actions act1=new Actions(driver);
	act1.moveToElement(profileIcon).perform();
		signout.click();
		}

}
