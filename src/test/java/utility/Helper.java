package utility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Helper {
	
	
	public static String captureScreenshot(WebDriver driver,String screenShotName)
	{
		
		TakesScreenshot ts = (TakesScreenshot)driver;
		
		File src = ts.getScreenshotAs(OutputType.FILE);
		
		String destination = "D:\\SeleniumProg\\AutomationPCCProject\\screenshots"+screenShotName+System.currentTimeMillis()+".png";
		
		try {
			FileUtils.copyFile(src, new File(destination));
		} catch (Exception e) {
			
			System.out.println("Exception is "+e.getMessage());
		}
		
		return destination;
		
		
	}

}
