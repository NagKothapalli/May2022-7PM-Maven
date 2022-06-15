package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import appUtilities.AppUtilities;
import generalUtilities.ReadProperties;

public class TrackService
{
	WebDriver driver; //null
	ReadProperties prop;
	AppUtilities appUtils;
	public TrackService(WebDriver driver) //1234
	{
		this.driver = driver; // a=a; a=b;
		prop = new ReadProperties("TestData/ApsrtcDev.properties");
		appUtils = new AppUtilities(driver);
	}
	//***************Xpath*********************
		String trackServiceTab = "//a[@title='Track Service']"; 
		String serviceNumberTxt = "//input[@name='serviceCode']";
	//********************************************
	public void trackTheTicketService()
	{
		System.out.println("RC : Track the Ticket Bus Service");
		appUtils.clickElement(trackServiceTab);
		appUtils.enterText(serviceNumberTxt, "12345678");
	}

}
