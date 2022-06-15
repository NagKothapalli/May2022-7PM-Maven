package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import generalUtilities.ReadProperties;

public class Login
{
	WebDriver driver; //null
	ReadProperties prop;
	public Login(WebDriver driver2) //1234
	{
		this.driver = driver2; // a=a; a=b;
		//driver = mydriver;
		prop = new ReadProperties("TestData/ApsrtcDev.properties");
	}
	
	public void launchApplication()
	{
		System.out.println("RC : Launch Application");		
		driver.get(prop.readData("URL")); //null.get() - nullPointerException
	}
	public void loginToApplication()
	{
		System.out.println("RC : Login To Application");
	}
	public void logoutFromApplication()
	{
		System.out.println("RC : Logout From Application");
	}
	public void closeApplication()
	{
		System.out.println("RC : Close Application");
	}

}
