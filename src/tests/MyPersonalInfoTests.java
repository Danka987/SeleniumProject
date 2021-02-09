package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MyPersonalInfoTests extends TestBase {
	@BeforeMethod
	public void setup() throws InterruptedException {
		driver.navigate().to("http://automationpractice.com/index.php");
		Thread.sleep(2000);
	}

	@Test
	public void editInfo() throws InterruptedException {
		String email = excelReader.getStringData("Edit_personal_info", 6, 4);
		String password = String.valueOf(excelReader.getIntData("Edit_personal_info", 7, 4));
		String newLastname = excelReader.getStringData("Edit_personal_info", 10, 4);
		String message = excelReader.getStringData("Edit_personal_info", 12, 4);
		indexPage.logIn(email, password);
		Thread.sleep(2000);
		myAccountPage.clickOnPersonalInfo();
		personalInfoPage.getLastNameField().sendKeys(newLastname);
		personalInfoPage.getPasswordField().sendKeys(password);
		personalInfoPage.clickOnSave();
		String textToAssert = personalInfoPage.getMessageToAssert().getText();
		Assert.assertEquals(textToAssert,message);
		
	}

	@AfterMethod
	public void afterTest() throws InterruptedException {
		driver.manage().deleteAllCookies();
		driver.navigate().refresh();
		Thread.sleep(2000);
	}
}
