package dataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class ConfigDataProvider {
	
	Properties prop;
	
	public ConfigDataProvider()
	{
		File src = new File("./Configuration/config.properties");
		
		try {
			FileInputStream fis = new FileInputStream(src);
			
			 prop = new Properties(); 
			prop.load(fis);
			
		} catch (Exception e) {
			
			System.out.println("Exception is "+e.getMessage());			
			
		}
		
		
	}

	
	public String getApplicationUrl()
	{
		String link =prop.getProperty("url");
		return link;
	}
	
	
	public String getChromePath()
	{
		String chromepath =prop.getProperty("chromepath");
		return chromepath;
	}
	public String getiePath()
	{
		String iepath =prop.getProperty("iepath");
		return iepath;
	}
	
	
	
	
	

}
