package pageObjects;

import org.openqa.selenium.chrome.ChromeDriver;

import appUtilities.AppUtilities;
import generalUtilities.ReadProperties;

public class TicketStatus
{
	ChromeDriver driver; //null
	ReadProperties prop;
	AppUtilities appUtils;
	public TicketStatus(ChromeDriver driver) //1234
	{
		this.driver = driver; // a=a; a=b;
		prop = new ReadProperties("TestData/ApsrtcDev.properties");
		appUtils = new AppUtilities(driver);
	}
	public void checkStatus()
	{
		System.out.println("RC : Check the Bus Ticket Status");
	}

}
