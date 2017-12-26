package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import factory.BrowserFactory;
import factory.DataProviderFactory;
import pages.CreateUpdateBL;
import pages.HomePages;
import pages.InvokeCreateBL;
import utility.Helper;

public class CreateCompleteBL {
	
	WebDriver driver;
	ExtentReports report;
	ExtentTest logger;
	
	@BeforeMethod
	public void setup() throws InterruptedException
	{
		
		report = new ExtentReports("./Reports/CreateBlReport.html",true);
		
		logger= report.startTest("Start the report");
		
		BrowserFactory brf = new BrowserFactory();
		driver = brf.getBrowser("FIREFOX");
		driver.get(DataProviderFactory.getConfig().getApplicationUrl());
		//Thread.sleep(4000);
		
		logger.log(LogStatus.INFO, "Application is Up and running");
		
	}
	
	@Test(priority=1)
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
		logger.log(LogStatus.INFO, "Application logged in successfully");
		logger.log(LogStatus.INFO,logger.addScreenCapture(Helper.captureScreenshot(driver,"Validation2")));
				
	/*}
	
	@Test(priority=2)
	public void createBL()
	{*/
		InvokeCreateBL cbl =PageFactory.initElements(driver, InvokeCreateBL.class);
		
		String bkg_No = DataProviderFactory.getExcel().getBookingNoString("bldata",2,0);
		
		cbl.setBkgNo(bkg_No);
		
		logger.log(LogStatus.INFO, "Got Booking Number from Excell file");
		
		cbl.proceedButton();
		
	/*}
	
	@Test(priority=3)
	public void CreateUpdateBLTest() throws InterruptedException
	{*/
		
		CreateUpdateBL cubl = PageFactory.initElements(driver, CreateUpdateBL.class);
		
		cubl.VerifyTitle();
		
		
		
		logger.log(LogStatus.PASS,"B/L creation page is loaded successfully");
		
		cubl.setGoodsDescription();
		
		logger.log(LogStatus.INFO, "Entered Goods Description");
		
		cubl.clickOnSave();
		
		logger.log(LogStatus.INFO, "Clicked on Save Button");
		
		cubl.transactionLog();
		
				
		Thread.sleep(9000);
		
		logger.log(LogStatus.INFO, "Entered Transaction log for draft");
		
		cubl.clickOnComplete();
		
		Thread.sleep(3000);
		
		logger.log(LogStatus.INFO, "Clicked on Complete Button");
		
		cubl.cmplTransactionLog();
		
		logger.log(LogStatus.INFO, "Entered Transaction log for Complete B/L");
		
		Thread.sleep(8000);
		
		cubl.getBLNumber();
		
		logger.log(LogStatus.PASS, "B/L No created Successfully");
		
		Thread.sleep(8000);
		
		/*driver.quit();
		
		report.endTest(logger);
		report.flush();
		*/
		
		
		
	}
	
	
	
	@AfterMethod
	public void CloseBrowswer(ITestResult result)
	{
		
		if(result.getStatus()==ITestResult.FAILURE)
		{
			String path = Helper.captureScreenshot(driver, result.getName());
			
			logger.log(LogStatus.FAIL, logger.addScreenCapture(path));
		}
		
		driver.quit();
		
		report.endTest(logger);
		
		report.flush();
		
	}

}
