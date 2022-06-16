package appUtilities;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import generalUtilities.ReadProperties;

public class DriverSetUp
{
	ReadProperties configData;
	WebDriver driver;
	public DriverSetUp()
	{
		configData = new ReadProperties("TestData/Config.properties");
	}
	
	public WebDriver getWebDriver()
	{
		if(configData.readData("ExecutionType").equalsIgnoreCase("LOCAL"))
		{
			driver = getLocalWebDriver();
		}
		else if(configData.readData("ExecutionType").equalsIgnoreCase("REMOTE"))
		{
			driver = getRemoteWebDriver();
		}
		else
		{
			driver = getLocalWebDriver();
		}
		return driver;
	}
	URL url;
	public WebDriver getRemoteWebDriver()
	{
		//url of the remote system - VM ip address |  URL of SauceLabs or Browser stack 
		//Capabilities - username , password , OS , Browser , Browser version , screen resolution		
		try {
			url = new URL(configData.readData("SaucelabsURL"));
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("name", configData.readData("ApplicationName"));
	    capabilities.setCapability(CapabilityType.BROWSER_NAME, configData.readData("Browser"));
	    capabilities.setCapability(CapabilityType.VERSION, configData.readData("BrowserVersion"));
	    capabilities.setCapability(CapabilityType.PLATFORM, configData.readData("OS"));
	    capabilities.setCapability("screen-resolution", configData.readData("ScreenResolution"));
	    capabilities.setCapability("username", configData.readData("SaucelabsUserName"));
	    capabilities.setCapability("accessKey", configData.readData("SaucelabsAccessKey"));
		driver = new RemoteWebDriver(url,capabilities);
		return driver;
	}
	      // int
	public WebDriver getLocalWebDriver()
	{
		if(configData.readData("Browser").equalsIgnoreCase("CHROME"))
		{
			System.setProperty("webdriver.chrome.driver", "D:\\Softwares\\JarFiles\\chromedriver-win32-90\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(configData.readData("Browser").equalsIgnoreCase("FIREFOX"))
		{
			System.setProperty("webdriver.gecko.driver", "D:\\Softwares\\JarFiles\\geckodriver-v0.31.0-win64\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		else if(configData.readData("Browser").equalsIgnoreCase("IE"))
		{
			System.setProperty("webdriver.ie.driver", "D:\\Softwares\\JarFiles\\IEDriverServer_Win32_4.2.0\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		else
		{
			System.setProperty("webdriver.chrome.driver", "D:\\Softwares\\JarFiles\\chromedriver-win32-90\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		return driver;
	}
	

}
