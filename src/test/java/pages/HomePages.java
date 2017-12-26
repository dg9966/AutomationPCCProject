package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import factory.DataProviderFactory;

public class HomePages
{
	WebDriver driver;
	
	public HomePages(WebDriver ldriver)	
	{
		
		this.driver=ldriver;
		
	}
	
	@FindBy(xpath="//input[@type='text']") WebElement userName;
	
	@FindBy(xpath="//input[@type='password']") WebElement password;
	
	@FindBy(xpath="//input[@value='Login']") WebElement login;
	
	public void getUserName(String user)
	{
		 userName.sendKeys(user);
	}
	
	public void getpassword(String pass)
	{
		password.sendKeys(pass);
	}
	
	public void ClickOnLogin()
	{
		login.click();
	}

	

}
