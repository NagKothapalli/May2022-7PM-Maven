package practiceTestNG;

import org.testng.annotations.Test;

public class TestCasesWithPriority
{
	@Test(priority=1)
	public void atestCase_1()
	{
		System.out.println("This is my TestCase-1");
	}
	@Test(priority=2)
	public void gtestCase_2()
	{
		System.out.println("This is my TestCase-2");
	}
	@Test(priority=3)
	public void btestCase_3()
	{
		System.out.println("This is my TestCase-3");
	}
	@Test(priority=4 , enabled=false)
	public void ktestCase_4()
	{
		System.out.println("This is my TestCase-4");
	}
	@Test   //default priority will be 0
	public void ktestCase_5()
	{
		System.out.println("This is my TestCase-5");
	}
	@Test   //default priority will be 0
	public void ktestCase_7()
	{
		System.out.println("This is my TestCase-7");
	}
	@Test(priority=0)   
	public void ktestCase_6()
	{
		System.out.println("This is my TestCase-6");
	}

}
