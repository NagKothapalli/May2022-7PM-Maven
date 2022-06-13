package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import generalUtilities.ReadProperties;

public class Login
{
	ChromeDriver driver; //null
	ReadProperties prop;
	public Login(ChromeDriver driver) //1234
	{
		this.driver = driver; // a=a; a=b;
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
