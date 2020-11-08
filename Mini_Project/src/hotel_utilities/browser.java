package hotel_utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;

public class browser {
	public static WebDriver driver;

	public static WebDriver InvokeBrowser(WebDriver driver,String browser) throws Exception {
				
		if(browser.equalsIgnoreCase("chrome")){
			
			ChromeOptions co=new ChromeOptions();
			co.addArguments("--disable-infobars");
			co.addArguments("--disable-notifications");
			co.addArguments("--start-maximized");
			
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\drivers\\chromedriver.exe");
			
			driver = new ChromeDriver(co);
			driver.manage().deleteAllCookies();
		}
		else if(browser.equalsIgnoreCase("opera"))
					{
						OperaOptions op=new OperaOptions();
						op.addArguments("--disable-infobars");
						op.addArguments("--disable-notifications");
						op.addArguments("--start-maximized");
			
						System.setProperty("webdriver.opera.driver", System.getProperty("user.dir")+"\\drivers\\operadriver.exe");
						driver=new OperaDriver(op);
						driver.manage().deleteAllCookies();
					}
		else System.out.println("Incorrect browser");
		return driver;
	}
}
