package hotel_utilities;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class excelFile {
	
	public static void entryExcelFile(WebDriver driver,String info) throws InterruptedException, IOException {
		
		XSSFWorkbook workbook=new XSSFWorkbook();
		XSSFSheet sheet=workbook.createSheet("DETAILS");		
		
		String data=driver.findElement(By.xpath(info)).getText();
		
		Row first= sheet.createRow(0);
		Cell Title=first.createCell(0);
		Title.setCellValue("Details:Total number of hotels available");
		
		XSSFRow row=sheet.createRow(1);
		XSSFCell cell=row.createCell(0);
		cell.setCellValue(data);
		
		FileOutputStream fileOutputStream = new FileOutputStream("HotelDetails.xlsx");
		workbook.write(fileOutputStream);
		workbook.close();

	}

}
