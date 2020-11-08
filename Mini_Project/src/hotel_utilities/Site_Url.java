package hotel_utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class Site_Url {
	
	public static void baseUrl(WebDriver driver,String URL) {
		
		driver.get(URL);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Actions act=new Actions(driver);
		act.moveByOffset(910, 500).doubleClick().build().perform();
	}

}
