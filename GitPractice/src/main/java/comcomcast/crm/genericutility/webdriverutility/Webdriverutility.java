package comcomcast.crm.genericutility.webdriverutility;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Webdriverutility {
 public void waitForPageToLoad(WebDriver driver)
   {
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
   }
 
public void waitForElementpresent(WebDriver driver,WebElement element)
 {
	WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
	wait.until(ExpectedConditions.visibilityOf(element));
 }

public void switchTotabOnUrl(WebDriver driver, String partialUrl)
  {
	Set<String> set=driver.getWindowHandles();
	Iterator<String> it = set.iterator();
	
	  while(it.hasNext())
	   {
	     String windowID=it.next();
	      driver.switchTo().window(windowID);
	  
          String acturl = driver.getCurrentUrl();
          if(acturl.contains(partialUrl));
          break;
	    }
   }

public void switchTotabOnTitle(WebDriver driver, String title)
{
	Set<String> set=driver.getWindowHandles();
	Iterator<String> it = set.iterator();
	
	  while(it.hasNext())
	   {
	     String windowID=it.next();
	      driver.switchTo().window(windowID);
	  
        String acturl = driver.getTitle();
        if(acturl.contains(title));
        break;
	    }
 }

 public void switchToFrameOnindex(WebDriver driver, int index)
  {
	driver.switchTo().frame(index);
  }

 public void switchToFrameOnNameID(WebDriver driver, String nameId)
  {
	driver.switchTo().frame(nameId);
  }

 public void switchToFrameOnWebElement(WebDriver driver, String element)
  {
	driver.switchTo().frame(element);
  }

 public void switchTOAlertToAccept(WebDriver driver)
 {
	 driver.switchTo().alert().accept();
 }
 
 public void switchTOAlertToDismiss(WebDriver driver)
 {
	 driver.switchTo().alert().dismiss();;
 }
 
 
 public void selectByVisibleText(WebElement element, String text)
  {
	 Select sel=new Select(element);
	 sel.selectByVisibleText(text);
  }
 public void selectByIndex(WebElement element, int index)
 {
	 Select sel=new Select(element);
	 sel.selectByIndex(index);
 }
 
 public void mousemoveOnelement(WebDriver driver,WebElement element)
 {
	 Actions act=new Actions(driver);
	 act.moveToElement(element).perform();
 }
 
 public void doubleclickOnelement(WebDriver driver,WebElement element)
 {
	 Actions act=new Actions(driver);
	 act.doubleClick(element).perform();
 }
 

}
