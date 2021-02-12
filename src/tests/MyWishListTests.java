package tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MyWishListTests extends TestBase {

	@BeforeMethod
	public void setup() throws InterruptedException {
		driver.navigate().to("http://automationpractice.com/index.php");
		Thread.sleep(2000);
	}

	@Test(priority = 5)
	public void addNewWishlist() throws InterruptedException {
		String email = excelReader.getStringData("Add_wish_list", 6, 4);
		String password = String.valueOf(excelReader.getIntData("Add_wish_list", 7, 4));
		String name = excelReader.getStringData("Add_wish_list", 10, 4);
		
		indexPage.logIn(email, password);
		myAccountPage.clickOnMyWishlist();
		myWishlistPage.getWishListNameField().sendKeys(name);
		myWishlistPage.ClickOnSave();
		Thread.sleep(2000);
		int numList = myWishlistPage.countWishlists();
		int number = excelReader.getIntData("Add_wish_list", 11, 4);
		assertEquals(numList, number);

    
       
	}

	@Test(priority = 10)
	public void addSecondWishlist() throws InterruptedException {
		String name = excelReader.getStringData("Add_second_wishlist", 10, 4);
		addNewWishlist();
		myWishlistPage.addWishlist(name);
		Thread.sleep(2000);
		int numList = myWishlistPage.countWishlists();
		int number = excelReader.getIntData("Add_second_wishlist", 11, 4);
		assertEquals(numList, number);
		Thread.sleep(2000);
		resetInfo();
	}

	@Test(priority = 0)
	public void removeWishlist() throws InterruptedException {

		addNewWishlist();
		Thread.sleep(2000);
		myWishlistPage.clickOnDelete();
		driver.switchTo().alert().accept();
		Thread.sleep(2000);
		driver.navigate().refresh();
		Thread.sleep(2000);
		int numList1 = myWishlistPage.countWishlists();
		int number1 = excelReader.getIntData("Remove_wish_list", 11, 4);
		assertEquals(numList1, number1);
	}

	@AfterMethod
	public void afterTest() throws InterruptedException {
		driver.manage().deleteAllCookies();
		driver.navigate().refresh();
		Thread.sleep(2000);
	}
	public void resetInfo() throws InterruptedException {
		indexPage.goToAccount();
		myAccountPage.clickOnMyWishlist();
		Thread.sleep(2000);
		myWishlistPage.clickOnDelete();
		driver.switchTo().alert().accept();
		Thread.sleep(2000);
		myWishlistPage.clickOnDelete();
		driver.switchTo().alert().accept();
		Thread.sleep(2000);
	}
}
