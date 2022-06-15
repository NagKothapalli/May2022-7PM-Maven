package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import appUtilities.AppUtilities;
import generalUtilities.ReadProperties;

public class TicketStatus
{
	WebDriver driver; //null
	ReadProperties prop;
	AppUtilities appUtils;
	public TicketStatus(WebDriver driver) //1234
	{
		this.driver = driver; // a=a; a=b;
		prop = new ReadProperties("TestData/ApsrtcDev.properties");
		appUtils = new AppUtilities(driver);
	}
	//***************Xpath*********************
	String checkStatus = "//a[@title='Ticket Status']";
	String ticketNumber = "//input[@name='id' and @class='searchTktCancel']";
	//****************************************
	public void checkStatus()
	{
		System.out.println("RC : Check the Bus Ticket Status");
		appUtils.clickElement(checkStatus);
		appUtils.enterText(ticketNumber, "12345678");		
	}

}
