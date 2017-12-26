package factory;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import dataProvider.ConfigDataProvider;

public class BrowserFactory {
	
	WebDriver driver;
	
	public WebDriver getBrowser(String browserName)
	{
		if(browserName.equalsIgnoreCase("firefox"))
		{
			driver=new FirefoxDriver();
		}
		
		else if(browserName.equalsIgnoreCase("chrome"))
		{
			//ConfigDataProvider conf = new ConfigDataProvider();
			
			//System.setProperty("webdriver.chrome.driver",conf.getChromePath());
			
			
			System.setProperty("webdriver.chrome.driver",DataProviderFactory.getConfig().getChromePath());
			
			driver=new ChromeDriver();
		}
		
		else if(browserName.equalsIgnoreCase("ie"))
		{
			//ConfigDataProvider conf = new ConfigDataProvider();
			
			//System.setProperty("webdriver.ie.driver",conf.getiePath());
			
			System.setProperty("webdriver.ie.driver",DataProviderFactory.getConfig().getiePath());
			
			driver= new InternetExplorerDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		return driver;
			
	}
	
	
	public void closeBrowser()
	{
		driver.quit();
	}
	

}
