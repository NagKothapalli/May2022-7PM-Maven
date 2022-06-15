package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import appUtilities.AppUtilities;
import generalUtilities.ReadProperties;

public class CancelTicket
{
	WebDriver driver; //null
	ReadProperties prop;
	AppUtilities appUtils;
	public CancelTicket(WebDriver driver) //1234
	{
		this.driver = driver; // a=a; a=b;
		prop = new ReadProperties("TestData/ApsrtcDev.properties");
		appUtils = new AppUtilities(driver);
	}
	//***************Xpath*********************
		String cancelTktTab = "//a[@title='Cancel Ticket']"; 
		String tktNumberTxt = "//input[@name='id']";
	//********************************************
	public void cancelBusTicket()
	{
		System.out.println("Cancel the Bus Ticket");
		appUtils.clickElement(cancelTktTab);
		appUtils.enterText(tktNumberTxt,"01234533");
	}

}
