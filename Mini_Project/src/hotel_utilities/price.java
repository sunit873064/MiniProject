package hotel_utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class price {
	
	public static void selectPriceRange(WebDriver driver,String minlimit,String maxlimit,String hotel) throws InterruptedException {
		
		//-----------------------------------------------------------set minimum limit-----------------------------------------------------------
		Thread.sleep(2000);
		WebElement SliderMin = driver.findElement(By.xpath(minlimit));
		Thread.sleep(3000);

		Actions moveSliderMin = new Actions(driver);
		Action action = moveSliderMin.dragAndDropBy(SliderMin, 70, 0).build();
		action.perform();
		
		//-----------------------------------------------------------set maximum limit-----------------------------------------------------------
		Thread.sleep(3000);
		WebElement SliderMax = driver.findElement(By.xpath(maxlimit));
		Thread.sleep(2000);

		Actions moveSliderMax = new Actions(driver);
		Action action1 = moveSliderMax.dragAndDropBy(SliderMax, -90, 0).build();
		action1.perform();
		Thread.sleep(2000);
		
		//-----------------------------------------------------------filter for hotel-----------------------------------------------------------
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,2000)");
		Thread.sleep(1000);
		driver.findElement(By.xpath(hotel)).click();
		Thread.sleep(2000);
	}

}
