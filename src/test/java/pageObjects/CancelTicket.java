package pageObjects;

import org.openqa.selenium.chrome.ChromeDriver;

import appUtilities.AppUtilities;
import generalUtilities.ReadProperties;

public class CancelTicket
{
	ChromeDriver driver; //null
	ReadProperties prop;
	AppUtilities appUtils;
	public CancelTicket(ChromeDriver driver) //1234
	{
		this.driver = driver; // a=a; a=b;
		prop = new ReadProperties("TestData/ApsrtcDev.properties");
		appUtils = new AppUtilities(driver);
	}
	public void cancelBusTicket()
	{
		System.out.println("Cancel the Bus Ticket");
	}

}
