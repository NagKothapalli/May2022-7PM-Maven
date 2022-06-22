package testScenarios;

import java.io.File;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
//import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import appUtilities.DriverSetUp;
import generalUtilities.ReadProperties;
import pageObjects.CancelTicket;
import pageObjects.Home;
import pageObjects.Login;
import pageObjects.TicketStatus;
import pageObjects.TrackService;

public class TestCases // extends Login,Home - multiple inheritance
{
	WebDriver driver;
	Login login;
	Home home;
	TicketStatus ticketStatus;
	TrackService trackService;
	CancelTicket cancelTicket;
	ReadProperties configData;

	public TestCases() {
		// DriverSetUp driverSetUp = new DriverSetUp();
		// driver = driverSetUp.getWebDriver();
		driver = new DriverSetUp().getWebDriver();
		login = new Login(driver);
		home = new Home(driver);
		ticketStatus = new TicketStatus(driver);
		trackService = new TrackService(driver);
		cancelTicket = new CancelTicket(driver);
	}
	String screenshotfilepath;
	public String TakeErrorScreenShot(String imageName) {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			Random ran = new Random();	
			System.out.println("My root directory :" + new File(".").getCanonicalPath());
			screenshotfilepath = new File(".").getCanonicalPath()+"\\ScreenShots\\"+imageName+ran.nextInt(9999)+".png";
			FileUtils.copyFile(scrFile, new File(screenshotfilepath));
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		scrFile = null;
		return screenshotfilepath;
	}

	@Test
	public void bookBusTicketAndPrint() {
		// launch , login , bookTicket , printTicket , logout , close
		System.out.println("Test Case : BookBusTicketAndPrint");
		login.launchApplication();
		login.loginToApplication();
		home.bookTicket();
		TakeErrorScreenShot("BookTicket");
		home.printTicket();
		TakeErrorScreenShot("PrintTicket");
		login.logoutFromApplication();
		login.closeApplication();
	}

	@Test
	public void bookBusTicketAndCheckStatus() {
		// launch , login , bookTicket , checkstatus , logout , close
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
	public void bookBusTicketAndTrackService() {
		// launch , login , bookTicket , trackservice , logout , close
		System.out.println("Test Case : BookBusTicketAndTrackService");
		login.launchApplication();
		login.loginToApplication();
		home.bookTicket();
		trackService.trackTheTicketService();
		login.logoutFromApplication();
		login.closeApplication();
	}

	@Test
	public void bookBusTicketAndCancelTicket() {
		// launch , login , bookTicket , cancelTicket , logout , close
		System.out.println("Test Case : BookBusTicketAndCancelTicket");
		login.launchApplication();
		login.loginToApplication();
		home.bookTicket();
		cancelTicket.cancelBusTicket();
		login.logoutFromApplication();
		login.closeApplication();
	}

	@Test
	public void bookBusTicketPrintAndTrackService() {
		// launch , login , bookTicket , printTicket, trackservice , logout , close
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
