package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MyAddressTests extends TestBase {
	
	@BeforeMethod
	public void setup() throws InterruptedException {
		driver.navigate().to("http://automationpractice.com/index.php");
		Thread.sleep(2000);
	}
	@Test
	public void updateAddress ()throws InterruptedException {
		String email = excelReader.getStringData("Log_In", 6, 4);
		String password = String.valueOf(excelReader.getIntData("Log_In", 7, 4));
		String adress2 = excelReader.getStringData("My_address", 11, 4);
		String UpdateText =excelReader.getStringData("My_address", 12, 4);
		
		indexPage.logIn(email, password);
		Thread.sleep(2000);
		myAccountPage.navigateToMyAddress();
		Thread.sleep(2000);
		myAddressesPage.clickOnUpdate();
		Thread.sleep(2000);
		myAddressesPage.inputAddress2(adress2);
		Thread.sleep(2000);
		myAddressesPage.saveUpdates();
		Thread.sleep(2000);
		String textToAssert = myAddressesPage.getTextToAssert().getText();
		Assert.assertEquals(textToAssert,UpdateText);
		
	}
	
	@AfterMethod
	public void afterTest() throws InterruptedException {
		driver.manage().deleteAllCookies();
		driver.navigate().refresh();
		Thread.sleep(2000);
	}
}
