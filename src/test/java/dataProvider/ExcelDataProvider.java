package dataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider {
	
	XSSFWorkbook wb;
	
	public ExcelDataProvider()
	{
		
		File src = new File("./ApplicationTestData/AppData.xlsx");
		
		try {
			FileInputStream fis = new FileInputStream(src);
			 wb = new XSSFWorkbook(fis);
			
		} catch (Exception e) {
			
			System.out.println("Exception is "+e.getMessage());
			
		}
		
	}
	
	
	
	public String getData(int sheetIndex, int row, int col)
	{
		
		String data =wb.getSheetAt(sheetIndex).getRow(row).getCell(col).getStringCellValue();
		
		return data;
		
	}
	
	

	public String getData1(String sheetName, int row, int col)
	{
		
		String data =wb.getSheet(sheetName).getRow(row).getCell(col).getStringCellValue();
		
		return data;
		
	}
	
	public int getBookingNo(String sheetName, int row, int col)
	{
		int bookingData = (int)wb.getSheet(sheetName).getRow(row).getCell(col).getNumericCellValue();
		return bookingData;
	}
	
	public String getBookingNoString(String sheetName, int row, int col)
	{
		
		String data =wb.getSheet(sheetName).getRow(row).getCell(col).getStringCellValue();
		
		return data;
		
	}

}
