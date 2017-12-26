package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class CreateUpdateBL {
	
	WebDriver driver;
	
	public CreateUpdateBL(WebDriver ldriver)
	{
		this.driver=ldriver;
	}
	
	By title = By.xpath("//h2");
    
	@FindBy(xpath="//h2") WebElement tittle;
	
	@FindBy(name="txtPkgDscr") WebElement gddescrip;
	
	@FindBy(xpath="//div[@id='grdBlCargo']/div/table[@class='k-selectable' ]/tbody/tr/td[text()='1']") WebElement gdSeq1;
	
	 @FindBy(xpath="//div[@id='grdBlCargo']/div/table[@class='k-selectable' ]/tbody/tr/td[text()='2']") WebElement gdSeq2;
	 
	 @FindBy(xpath="//div[@id='grdBlCargo']/div/table[@class='k-selectable' ]/tbody/tr/td[text()='3']") WebElement gdSeq3;
	 
	 //Total no of row at Good Description table
	 
	 @FindBy(xpath="//div[@id='grdBlCargo']/div/table[@class='k-selectable' ]/tbody/tr") List<WebElement> TotalNoOfCargo;
	 
	 @FindBy(id="btnSave") WebElement save;
	 
	 @FindBy(name="XnsTxt") WebElement textArea;
	 
	 @FindBy(xpath="//input[@value='SAVE LOG']") WebElement saveLog;
	 
	 @FindBy(id="btnComplete") WebElement CompleteBtn;
	 
	 @FindBy(id="BlNo") WebElement BL_NO;
	 
	 @FindBy(xpath="//textarea[@id='txtAreaRemarks']") WebElement cmplTextArea;
	 
	 @FindBy(xpath="//input[@id='btnContinue']") WebElement cmplSaveLog;
	 
	 
	 public void VerifyTitle()
	 {
		 WebDriverWait wait = new  WebDriverWait(driver,10);
		 
		WebElement ele = wait.until(ExpectedConditions.presenceOfElementLocated(title));
		
		String text = ele.getText();
		
		//Assert.assertEquals(text,"Create/Modify Bill of Lading(OPBLW03)", "Not Opened required pages");
		
		//Assert.assertEquals(text.contains("Lading"),"Create/Modify Bill of Lading(OPBLW03)" );
		
		System.out.println("Text is "+text);
		
		Assert.assertTrue(text.contains("Create"));
	 }
	 
	 public void setGoodsDescription() throws InterruptedException
	 {
		System.out.println("Total no of cargo - "+TotalNoOfCargo.size()); 
		
		gdSeq1.click();
		 
		 gddescrip.sendKeys("generated from B/L print and Mass B/L print for Agent Screen1");
		 
		 TotalNoOfCargo.get(1).click();
		 
		 Thread.sleep(3000);
		 
		 gddescrip.sendKeys("generated from B/L print and Mass B/L print for Agent Screen2");
		 
		 TotalNoOfCargo.get(2).click();
		 
		 Thread.sleep(3000);
		 
		 gddescrip.sendKeys("generated from B/L print and Mass B/L print for Agent Screen3");
		 
		 TotalNoOfCargo.get(1).click();
		 Thread.sleep(2000);
		/*		 
		 gdSeq2.click();		 
		 
		 Thread.sleep(3000);
		 
		 if(gdSeq2.isSelected())
		 {
		 gddescrip.sendKeys("generated from B/L print and Mass B/L print for Agent Screen2"); 
		 }				 
		 else
		 {
			 gdSeq2.click();
			 
			 gddescrip.sendKeys("generated from B/L print and Mass B/L print for Agent Screen2");
		 }		 
		
		 gdSeq3.click();
		 
		 Thread.sleep(3000);
		 
		 gddescrip.sendKeys("generated from B/L print and Mass B/L print for Agent Screen3");
		 */
		 
		 
		 
		 
		 
	 }
	
	 
	 
	 public void clickOnSave()
	 {
		 save.click();
	 }
	 
	 public void transactionLog()
	 {
		 textArea.sendKeys("Text Area");
		 
		 saveLog.click();
				 
	 }
	 
	 public void clickOnComplete()
	 {
		 CompleteBtn.click();
	 }
	 
	 public void getBLNumber()
	 {
		 String bl_number=BL_NO.getText();
		 
		 System.out.println("B/L Number- "+bl_number);
				 
	 }
	 
	 public void cmplTransactionLog()
	 {
		 cmplTextArea.sendKeys("TextArea Complete");
		 
		 cmplSaveLog.click();
	 }
}
