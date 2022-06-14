package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import appUtilities.AppUtilities;
import generalUtilities.CommonFunctions;
import generalUtilities.ReadProperties;

public class Home
{
	ChromeDriver driver; //null
	ReadProperties prop;
	AppUtilities appUtils;
	public Home(ChromeDriver driver) //1234
	{
		this.driver = driver; // a=a; a=b;
		prop = new ReadProperties("TestData/ApsrtcDev.properties");
		appUtils = new AppUtilities(driver);
	}
	//*****************XPATHS*******************
		String sourceXpath = "//input[@name='source']";
		String destinationXpath = "//input[@name='destination']";
	//******************************************
	public void bookTicket()
	{
		System.out.println("RC : Book Bus Ticket");
		appUtils.enterText(sourceXpath,prop.readData("FromCity"));
		CommonFunctions.fixedWait(1);
		appUtils.clickEnter();
		appUtils.enterText(destinationXpath,prop.readData("ToCity"));
		CommonFunctions.fixedWait(1);
		appUtils.clickEnter();
		driver.findElement(By.xpath("//input[@name='txtJourneyDate']")).click();
		//select date of journey
		selectDate(prop.readData("JDate"));
		driver.findElement(By.xpath("//input[@name='searchBtn']")).click();
		CommonFunctions.fixedWait(1);
		appUtils.clickElement("//a[@title='Home']");
	}
	
	public void navigateToHome()
	{
		appUtils.clickElement("//a[@title='Home']");
	}
	
	public void selectDate(String jDate)
	{
		//Dynamic xpath
		driver.findElement(By.xpath("//a[text()='"+jDate+"']")).click();
	}
	
	public void printTicket()
	{
		System.out.println("RC : Print Bus Ticket");
	}

}
