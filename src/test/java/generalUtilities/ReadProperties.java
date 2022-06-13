package generalUtilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadProperties 
{
	String myfileName;
	FileInputStream myfile;
	Properties prop;
	public ReadProperties(String filename)
	{
		myfileName = filename;
	}
	public String readData(String mykey) //throws IOException
	{		
		try {
			myfile = new FileInputStream(myfileName);
			prop = new Properties(); // News Reader
			prop.load(myfile);
		} catch ( Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} //News Paper
		
		return prop.getProperty(mykey);		
	}

}
