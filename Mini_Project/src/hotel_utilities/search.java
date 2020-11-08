package hotel_utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class search {
	
	public static void searchHotels(WebDriver driver,String search1) throws InterruptedException {
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath(search1)).click();
		
	}

}
