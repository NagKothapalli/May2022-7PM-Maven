package testScenarios;

import java.io.File;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import generalUtilities.ReadProperties;
import pageObjects.CancelTicket;
import pageObjects.Home;
import pageObjects.Login;
import pageObjects.TicketStatus;
import pageObjects.TrackService;

public class TestCases //extends Login,Home  - multiple inheritance
{
	WebDriver driver;
	Login login ;
	Home home ;
	TicketStatus ticketStatus ;
	TrackService trackService ;
	CancelTicket cancelTicket ;
	ReadProperties configData;
	public TestCases()
	{
		configData = new ReadProperties("TestData/Config.properties");
		if(configData.readData("Browser").equalsIgnoreCase("CHROME"))
		{
			System.setProperty("webdriver.chrome.driver", "D:\\Softwares\\JarFiles\\chromedriver-win32-90\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(configData.readData("Browser").equalsIgnoreCase("FIREFOX"))
		{
			System.setProperty("webdriver.chrome.driver", "D:\\Softwares\\JarFiles\\chromedriver-win32-90\\chromedriver.exe");
			driver = new FirefoxDriver();
		}
		else if(configData.readData("Browser").equalsIgnoreCase("IE"))
		{
			System.setProperty("webdriver.chrome.driver", "D:\\Softwares\\JarFiles\\chromedriver-win32-90\\chromedriver.exe");
			driver = new InternetExplorerDriver();
		}
		else
		{
			System.setProperty("webdriver.chrome.driver", "D:\\Softwares\\JarFiles\\chromedriver-win32-90\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		
		login = new Login(driver);
		home = new Home(driver);
		ticketStatus = new TicketStatus(driver);
		trackService = new TrackService(driver);
		cancelTicket = new CancelTicket(driver);
	}
	
	@Test
	public void bookBusTicketAndPrint()
	{		
		//launch , login , bookTicket , printTicket , logout , close
		System.out.println("Test Case : BookBusTicketAndPrint");
		login.launchApplication();
		login.loginToApplication();
		home.bookTicket();
		home.printTicket();
		login.logoutFromApplication();
		login.closeApplication();
	}
	@Test
	public void bookBusTicketAndCheckStatus()
	{
		//launch , login , bookTicket , checkstatus , logout , close
		System.out.println("Test Case : BookBusTicketAndCheckStatus");
		login.launchApplication();
		login.loginToApplication();
		home.bookTicket();
		ticketStatus.checkStatus();
		home.navigateToHome();
		login.logoutFromApplication();
		login.closeApplication();
	}
	@Test
	public void bookBusTicketAndTrackService()
	{
		//launch , login , bookTicket , trackservice , logout , close
		System.out.println("Test Case : BookBusTicketAndTrackService");
		login.launchApplication();
		login.loginToApplication();
		home.bookTicket();
		trackService.trackTheTicketService();
		login.logoutFromApplication();
		login.closeApplication();
	}
	@Test
	public void bookBusTicketAndCancelTicket()
	{
		//launch , login , bookTicket , cancelTicket , logout , close
		System.out.println("Test Case : BookBusTicketAndCancelTicket");
		login.launchApplication();
		login.loginToApplication();
		home.bookTicket();
		cancelTicket.cancelBusTicket();
		login.logoutFromApplication();
		login.closeApplication();
	}
	@Test
	public void bookBusTicketPrintAndTrackService()
	{
		//launch , login , bookTicket , printTicket, trackservice , logout , close
		System.out.println("Test Case : BookBusTicketPrintAndTrackService");
		login.launchApplication();
		login.loginToApplication();
		home.bookTicket();
		home.printTicket();
		trackService.trackTheTicketService();
		login.logoutFromApplication();
		login.closeApplication();
	}

}
