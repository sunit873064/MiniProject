package hotel_utilities;

import org.testng.Assert;
import org.testng.annotations.*;

public class test1 {
	
	@BeforeMethod
	public void login() {
		System.out.println("Login Application");	
	}
	@BeforeSuite
	public void database() {
		System.out.println("Database connected");	
	}
	
	@Test
	public void testOne() {
		System.out.println(" test case 1");	
		Assert.assertEquals(1,1, "Test 1 varified");
	}
	
	
	@Test(priority=1)
	public void testTwo() {
		System.out.println("test case 2");	
		Assert.assertEquals(2,2, "Test 2 varified");
	}
	
	
	@Test(dependsOnMethods= {"testOne","testTwo"})
	public void testThree() {
		System.out.println("test case 3");	
		Assert.assertEquals(3,3, "Test 3 varified");
	}
	
	@AfterMethod
	public void logout() {
		System.out.println("Logout");	
	}
	
	@AfterTest
	public void report() {
		System.out.println("report generated");
	}

}
/*Login Application.
Connect to DB and verify title.
Test case 1
Test case validation
Test Case 2
Test case validation
Test case 3 after Test case 1 and Test case 2.
Test case validation
Log Out.
Report Generated.*/