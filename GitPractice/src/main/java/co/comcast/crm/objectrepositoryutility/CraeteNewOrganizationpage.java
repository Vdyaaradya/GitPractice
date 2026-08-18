package co.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CraeteNewOrganizationpage {
	@FindBy(name = "accountname")
	private WebElement organizationnameEdit;

	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement save;
	
	@FindBy(name = "industry")
	private WebElement industry12;


	public WebElement getIndustry() {
		return industry12;
	}
	public WebElement getIndustrytype() {
		return industrytype;
	}
	@FindBy(name = "accounttype")
	private WebElement industrytype;
	
	
	
	
	WebDriver driver;
	public  CraeteNewOrganizationpage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public WebElement getOrganizationnameEdit() {
		return organizationnameEdit;
	}

	public WebElement getSave() {
		return save;
	}
	
	public void createorgname(String orgname)
	{
	organizationnameEdit.sendKeys(orgname);
	save.click();
	}
	
	public void createorgname(String orgname,String industryname,String industrytypeName)
	{
	organizationnameEdit.sendKeys(orgname);
	Select sel=new Select(industry12);
	sel.selectByValue(industryname);
	Select sel2=new Select(industrytype);
	sel2.selectByValue(industrytypeName);
	save.click();
	}

}
