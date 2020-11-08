package hotel_Automation;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import hotel_utilities.Site_Url;
import hotel_utilities.browser;
import hotel_utilities.date;
import hotel_utilities.excelFile;
import hotel_utilities.location;
import hotel_utilities.price;
import hotel_utilities.room;
import hotel_utilities.search;

public class main_class {
	static WebDriver driver;
	// To read all variables from property file 
	//----------------------------------------------------------REUSEABLE METHOD-----------------------------------------------------------
	
	public static String readpropertyfile(String value) throws IOException
	{
		 Properties prop = new Properties();
		
		 try {
			InputStream input = new FileInputStream(System.getProperty("user.dir")+"\\src\\hotel_utilities\\Hotel_resources.properties");
		    prop.load(input);
		  
		 } catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		 return   prop.getProperty(value);   
	}
//Main method from which we will call all other functions 
	//------------------------------------------------------------MAIN CALLING FUNCTION-----------------------------------------------------------------------------------------
	@Test
	public static void HotelAutomation() throws IOException, Exception  
	{
		
		//---------------------------------------------------Invoke and set browser----------------------------------------------------------------------------------------------------
		driver=browser.InvokeBrowser(driver,readpropertyfile("browser"));
		System.out.println("1.Browser invoked read by property file");
		 
		
		//---------------------------------------------------Open baseURL=https://www.makemytrip.com/hotels/----------------------------------------------------------------------------------------------------
		Site_Url.baseUrl(driver, readpropertyfile("URL"));
		System.out.println("2.URL is opened");
		
		//---------------------------------------------------Select location----------------------------------------------------------------------------------------------------
		Thread.sleep(1000);
		location.SelectLocation(driver, readpropertyfile("Location_part1_path"), readpropertyfile("Location_part2_path"), readpropertyfile("region"),readpropertyfile("location_option1_path"));
		System.out.println("3.Location for hotel is selected");
		
		//---------------------------------------------------date selection----------------------------------------------------------------------------------------------------
		date.selectDate(driver, readpropertyfile("checkin_id"));
		System.out.println("4.Checkin and checkout date is selected");
		
		//---------------------------------------------------select room----------------------------------------------------------------------------------------------------
		room.selectRoom(driver, readpropertyfile("guest_id"), readpropertyfile("guest_path"));
		System.out.println("5.Room is selected");
		
		//---------------------------------------------------Search----------------------------------------------------------------------------------------------------
		search.searchHotels(driver, readpropertyfile("search_path"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("6.Searched for the given data");
		
		//---------------------------------------------------set filter for price----------------------------------------------------------------------------------------------------
		price.selectPriceRange(driver, readpropertyfile("minlimit_path"), readpropertyfile("maxlimit_path"), readpropertyfile("hotel_filter_path"));
		System.out.println("7.Applied the price filter");
		//In applied filter there is different limitations for the different date so i just using the filter close to 2000-3000 if it is not available for particular date
		
		//---------------------------------------------------print value----------------------------------------------------------------------------------------------------
		Thread.sleep(3000);
		System.out.println("8.Result:");
		String a=driver.findElement(By.xpath(readpropertyfile("info_path"))).getText();
		System.out.println(a);
		
		excelFile.entryExcelFile(driver, readpropertyfile("info_path"));
		
		Thread.sleep(3000);
		driver.quit();
			
		}
	}


