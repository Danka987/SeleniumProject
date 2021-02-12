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
	@Test (priority = 10)
	public void updateAddress ()throws InterruptedException {
		String email = excelReader.getStringData("My_address_update", 6, 4);
		String password = String.valueOf(excelReader.getIntData("My_address_update", 7, 4));
		String adress2 = excelReader.getStringData("My_address_update", 11, 4);
		String UpdateText =excelReader.getStringData("My_address_update", 12, 4);
		
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
		
		restoreOldInfo();
		
	}
	@Test (priority = 5)
	public void addNewAddress ()throws InterruptedException {
		String email = excelReader.getStringData("Add_address", 6, 4);
		String password = String.valueOf(excelReader.getIntData("Add_address", 7, 4));
		String address = excelReader.getStringData("Add_address", 10, 4);
		String city = excelReader.getStringData("Add_address", 11, 4);
		String alias = excelReader.getStringData("Add_address", 16, 4);
		String postcode = String.valueOf(excelReader.getIntData("Add_address", 14, 4));
		String phone = String.valueOf(excelReader.getIntData("Add_address", 15, 4));
		String newAddress = excelReader.getStringData("Add_address", 17, 4);
		
		indexPage.logIn(email, password);
		Thread.sleep(2000);
		myAccountPage.navigateToMyAddress();
		Thread.sleep(2000);
		myAddressesPage.clickOnNewAddressButton();
		Thread.sleep(2000);
		inputFields(address, city, postcode, phone, alias);
		String textToAssert = myAddressesPage.getForAssertNewAddres().getText();
		Assert.assertEquals(textToAssert,newAddress);
	}
	@Test (priority = 0)
	public void deleteAddress ()throws InterruptedException {
		String newAddress = excelReader.getStringData("Remove_address ", 18, 4);
	
		addNewAddress();
		Thread.sleep(2000);
		myAddressesPage.deleteAddress();
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		String textToAssert = myAddressesPage.getForAssertFirstAdress().getText();
		Assert.assertNotEquals(textToAssert,newAddress);
		
	}
	
	@AfterMethod
	public void afterTest() throws InterruptedException {
		driver.manage().deleteAllCookies();
		driver.navigate().refresh();
		Thread.sleep(2000);
	}
	public void inputFields (String addressField, String cityField, String postcodeField,
			String phoneField, String aliasAddress) {
		
		myAddressesPage.getAddressField().sendKeys(addressField);
		myAddressesPage.getCityField().sendKeys(cityField);
		myAddressesPage.clickOnStateBar();
		myAddressesPage.chooseState();
		myAddressesPage.getPostcodeField().sendKeys(postcodeField);
		myAddressesPage.getPhoneField().sendKeys(phoneField);
		myAddressesPage.getAliasAddress().clear();
		myAddressesPage.getAliasAddress().sendKeys(aliasAddress);
		myAddressesPage.saveUpdates();


		
	}
	public void restoreOldInfo() throws InterruptedException {
		
		indexPage.goToAccount();
		myAccountPage.navigateToMyAddress();
		myAddressesPage.deleteAddress();
		driver.switchTo().alert().accept();
		myAddressesPage.clickOnUpdate();
		myAddressesPage.getAdressField2().clear();
		Thread.sleep(2000);
		myAddressesPage.saveUpdates();
	}
}
