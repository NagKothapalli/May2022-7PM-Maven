package pageObjects;

import org.openqa.selenium.chrome.ChromeDriver;

import appUtilities.AppUtilities;
import generalUtilities.ReadProperties;

public class TrackService
{
	ChromeDriver driver; //null
	ReadProperties prop;
	AppUtilities appUtils;
	public TrackService(ChromeDriver driver) //1234
	{
		this.driver = driver; // a=a; a=b;
		prop = new ReadProperties("TestData/ApsrtcDev.properties");
		appUtils = new AppUtilities(driver);
	}
	public void trackTheTicketService()
	{
		System.out.println("RC : Track the Ticket Bus Service");
	}

}
