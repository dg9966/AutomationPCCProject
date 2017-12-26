package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InvokeCreateBL {
	
	WebDriver driver;
	
	public InvokeCreateBL(WebDriver ldriver)
	{
		this.driver=ldriver;
	}
	
	@FindBy(id="BkgNo") WebElement bkg_no;
	
	@FindBy(id="btnProceed") WebElement proceed;
	
	public void setBkgNo(String bkgNo)
	{
		
		bkg_no.sendKeys(String.valueOf(bkgNo));
		
		bkg_no.sendKeys(Keys.TAB);
		
	}
	
	
	public void proceedButton()
	{
		WebDriverWait wait = new WebDriverWait(driver,10);
		
		 wait.until(ExpectedConditions.elementToBeClickable(proceed));
		
		proceed.click();
		
	}
	
	

}
