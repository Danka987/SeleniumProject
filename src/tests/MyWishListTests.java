package tests;


import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MyWishListTests extends TestBase {
	
	@BeforeMethod
	public void setup() throws InterruptedException {
		driver.navigate().to("http://automationpractice.com/index.php");
		Thread.sleep(2000);
	}
	@Test (priority = 5)
	public void addNewWishlist()throws InterruptedException {
		String email = excelReader.getStringData("Add_wish_list", 6, 4);
		String password = String.valueOf(excelReader.getIntData("Add_wish_list", 7, 4));
		//String email = excelReader.getStringData("Log_In", 6, 4);
		//String password = String.valueOf(excelReader.getIntData("Log_In", 7, 4));
		//
		String name = excelReader.getStringData("Add_wish_list", 10, 4);
		//String wishlistName = excelReader.getStringData("Add_wish_list", 11, 4);
		
		indexPage.logIn(email, password);
		myAccountPage.clickOnMyWishlist();
		myWishlistPage.getWishListNameField().sendKeys(name);
		myWishlistPage.ClickOnSave();
		myWishlistPage.AssertWishlist();
		Thread.sleep(2000);
	}
	
	
	
	@Test(priority = 0)
	public void removeWishlist()throws InterruptedException {
		
		
		addNewWishlist();
		Thread.sleep(2000);
		myWishlistPage.clickOnDelete();
		driver.switchTo().alert().accept();
		myWishlistPage.AssertWishlist();
		Thread.sleep(2000);
		
	}
	@AfterMethod
	public void afterTest() throws InterruptedException {
		driver.manage().deleteAllCookies();
		driver.navigate().refresh();
		Thread.sleep(2000);
	}
}
