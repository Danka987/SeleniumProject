package tests;


import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LogInTests extends TestBase {

	@BeforeMethod
	public void setup() throws InterruptedException {
		driver.navigate().to("http://automationpractice.com/index.php");
		Thread.sleep(2000);
	}

	@Test
	public void logInRealCredenitals() throws InterruptedException {
		String email = excelReader.getStringData("Log_In", 6, 4);
		String password = String.valueOf(excelReader.getIntData("Log_In", 7, 4));
		String logIntext = excelReader.getStringData("Log_In", 8, 4);
		indexPage.logIn(email, password);		
		String textForAssert = indexPage.getAssertThatUserIsLoggedIn().getText();
		Assert.assertEquals(textForAssert, logIntext);
		Thread.sleep(2000);

	}

	@Test
	public void logInWrongEmail() throws InterruptedException {
		String email = excelReader.getStringData("Log_In", 6, 5);
		String password = String.valueOf(excelReader.getIntData("Log_In", 7, 4));
		String alertText = excelReader.getStringData("Log_In", 8, 5);
		indexPage.logIn(email, password);
		Thread.sleep(2000);
		String textForAssert = indexPage.getAssertThatUserIsNotLoggedIn().getText();
		Assert.assertEquals(textForAssert, alertText);
		Thread.sleep(2000);

	}

	@Test
	public void logInWrongPassword() throws InterruptedException {
		String email = excelReader.getStringData("Log_In", 6, 4);
		String password = String.valueOf(excelReader.getIntData("Log_In", 7, 5));
		String alertText = excelReader.getStringData("Log_In", 8, 5);
		indexPage.logIn(email, password);
		Thread.sleep(2000);
		String textForAssert = indexPage.getAssertThatUserIsNotLoggedIn().getText();
		Assert.assertEquals(textForAssert, alertText);
		Thread.sleep(2000);
	}
	@Test
	public void logInWithoutCredentials() throws InterruptedException {
		String email = excelReader.getStringData("Log_In", 6, 4);
		String password = String.valueOf(excelReader.getIntData("Log_In", 7, 5));
		String alertText = excelReader.getStringData("Log_In", 8, 6);
		
		indexPage.logIn(email, password);
		Thread.sleep(2000);
		String textForAssert = indexPage.getAssertThatUserIsNotLoggedIn().getText();
		Assert.assertEquals(textForAssert, alertText);
		Thread.sleep(2000);
		
		//proveriti za null
	}

	@AfterMethod
	public void afterTest() throws InterruptedException {
		driver.manage().deleteAllCookies();
		driver.navigate().refresh();
		Thread.sleep(2000);
	}

}
