package appUtilities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AppUtilities
{
	WebDriver driver;
	Actions actions;
	WebDriverWait wait;
	WebElement element;
	public AppUtilities(WebDriver driver) //1234
	{
		this.driver = driver; //1234
		actions = new Actions(driver);
		wait = new WebDriverWait(driver,Duration.ofSeconds(30));
	}
	public void clickEnter()
	{
		actions.sendKeys(Keys.ENTER).build().perform();
	}
	public void clickTab()
	{
		actions.sendKeys(Keys.TAB).build().perform();
	}	
	public void doubleClick(WebElement element)
	{
		actions.moveToElement(element).doubleClick().build().perform();
	}
	public void rightClick(WebElement element)
	{
		actions.moveToElement(element).contextClick().build().perform();
	}
	public void clickElement(String myxpath)
	{
		//element = driver.findElement(By.xpath(myxpath));		
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(myxpath)))); //Explicit Wait
		driver.findElement(By.xpath(myxpath)).click();
	}
	public void enterText(String myxpath,String txt)
	{
		//element = driver.findElement(By.xpath(myxpath));
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(myxpath)))); //Explicit Wait
		driver.findElement(By.xpath(myxpath)).sendKeys(txt);
	}

}
