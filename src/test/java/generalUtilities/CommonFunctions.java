package generalUtilities;

public class CommonFunctions
{
	public static void fixedWait(int timeInSec)
	{
		try {
			Thread.sleep(timeInSec * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
