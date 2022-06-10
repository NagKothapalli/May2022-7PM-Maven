package com.May2022_7PM_Maven;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;


/**
 * Unit test for simple App.
 */
public class AppTest 
{
	String expectedTitle = "Gmail";
	ChromeDriver driver;
	public AppTest()
	{
		System.setProperty("webdriver.chrome.driver", "D:\\Softwares\\JarFiles\\chromedriver-win32-90\\chromedriver.exe");
		driver = new ChromeDriver(); //it will open an empty browser
	}
	@Test
	public void launchApplication() throws InterruptedException
	{
		System.out.println("RC : Launch Application");
		//open an empty browser
		
		//Every browser window will have a unique session ID 
		//call the url
		driver.get("https://gmail.com");
		String url = driver.getCurrentUrl();
		System.out.println("My URL :" + url);
	}
}
