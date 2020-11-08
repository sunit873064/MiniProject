package hotel_utilities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import hotel_Automation.main_class;

public class date extends main_class {
	
		public static String setDate(int incr) {
			
			LocalDate c = LocalDate.now(); 
			c=c.plusDays(incr);
			String finalDate = c.format(DateTimeFormatter.ofPattern("EEE MMM dd yy"));
			return finalDate;
			
		}
	
	
	
		public static void selectDate(WebDriver driver,String checkin) throws InterruptedException {
			
			
			driver.findElement(By.id(checkin)).click();
			String inDate=setDate(7);
			Thread.sleep(2000);
			driver.findElement(By.xpath("//div[contains(@aria-label,'"+inDate+"')]")).click();
			Thread.sleep(2000);
			
			String outDate=setDate(9);
			driver.findElement(By.xpath("//div[contains(@aria-label,'"+outDate+"')]")).click();
			Thread.sleep(2000);
			
		}
			
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*public static void selectDate(WebDriver driver,String checkin,String date1,String date2) throws InterruptedException {
		Thread.sleep(2000);
		
		driver.findElement(By.id(checkin)).click();
		
		driver.findElement(By.xpath(date1)).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath(date2)).click();
		
	}*/

}
