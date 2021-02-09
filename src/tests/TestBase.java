package tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import pages.IndexPage;
import pages.MyAccountPage;
import pages.MyAddressesPage;
import pages.MyWishlistPage;
import pages.PersonalInfoPage;


public class TestBase {

	WebDriver driver;
	ExcelReader excelReader;
	
	//pages
	IndexPage indexPage;
	MyAccountPage myAccountPage;
	MyAddressesPage myAddressesPage;
	PersonalInfoPage personalInfoPage;
	MyWishlistPage myWishlistPage;
	
	@BeforeClass
	public void preKlase() throws IOException {
		System.setProperty("webdriver.chrome.driver", "driver-lib\\chromedriver.exe");

		this.driver = new ChromeDriver();
		excelReader = new ExcelReader("data/test plan.xlsx");
		this.indexPage = new IndexPage(driver);
		this.myAccountPage = new MyAccountPage(driver);
		this.myAddressesPage = new MyAddressesPage(driver);
		this.personalInfoPage = new PersonalInfoPage(driver);
		this.myWishlistPage = new MyWishlistPage(driver);

		driver.manage().window().maximize();
	}

	@AfterClass
	public void posleKlase() {
		driver.close();

	}
}
