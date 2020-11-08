package hotel_utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class location {
	
	public static void SelectLocation(WebDriver driver,String location1,String location2,String region1,String locationOption) throws InterruptedException {
		
		driver.findElement(By.xpath(location1)).sendKeys("");
		Thread.sleep(3000);
		driver.findElement(By.xpath(location2)).sendKeys(region1);
		Thread.sleep(5000);
		driver.findElement(By.xpath(locationOption)).click();
	}

}
