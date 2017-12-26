package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import factory.BrowserFactory;
import factory.DataProviderFactory;
import pages.CreateUpdateBL;
import pages.HomePages;
import pages.InvokeCreateBL;

public class VerifyLogin {
	
	WebDriver driver;
	
	@BeforeMethod
	public void setup() throws InterruptedException
	{
		BrowserFactory brf = new BrowserFactory();
		driver = brf.getBrowser("FIREFOX");
		driver.get(DataProviderFactory.getConfig().getApplicationUrl());
		//Thread.sleep(4000);
		
	}
	@Test(priority=0)
	public void ApplicationLogin() throws InterruptedException
	{
		HomePages home = PageFactory.initElements(driver, HomePages.class);
		
		//String name=DataProviderFactory.getExcel().getData(0,0,0);
		//String pass=DataProviderFactory.getExcel().getData(0,0,1);
		
		String name=DataProviderFactory.getExcel().getData1("data",0,0);
		String pass=DataProviderFactory.getExcel().getData1("data",0,1);
		
		home.getUserName(name);
		home.getpassword(pass);
		home.ClickOnLogin();
		
		
		InvokeCreateBL cbl =PageFactory.initElements(driver, InvokeCreateBL.class);
		
		String bkg_No = DataProviderFactory.getExcel().getBookingNoString("bldata",2,0);
		
		cbl.setBkgNo(bkg_No);
		
		cbl.proceedButton();
		
		CreateUpdateBL cubl = PageFactory.initElements(driver, CreateUpdateBL.class);
		
		cubl.VerifyTitle();
		
		Thread.sleep(8000);
		
		driver.quit();
		
	
	
	}
	
	/*@Test(priority=2)
	public void CreateUpdateBLTest() throws InterruptedException
	{
		
		CreateUpdateBL cubl = PageFactory.initElements(driver, CreateUpdateBL.class);
		
		cubl.setGoodsDescription();
		
		cubl.clickOnSave();
		
		cubl.transactionLog();
		
		Thread.sleep(8000);
		
		cubl.clickOnComplete();
		
		Thread.sleep(3000);
		
		cubl.cmplTransactionLog();
		
		Thread.sleep(3000);
		
		cubl.getBLNumber();
		
		
		
	}*/
	
	
	
	/*@AfterTest
	public void CloseBrowswer()
	{
		driver.quit();
	}*/

}
