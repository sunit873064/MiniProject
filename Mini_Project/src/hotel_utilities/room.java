package hotel_utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class room {
	
	public static void selectRoom(WebDriver driver,String guest,String guest_path) throws InterruptedException {
		
		Thread.sleep(2000);
		driver.findElement(By.id(guest)).click();

		driver.findElement(By.xpath(guest_path)).click();
	}

}
