package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MyAccountPage {
	WebDriver driver;
	WebElement myAddressesButton;
	WebElement myPersonalInfoButton;
	WebElement myWishlistButton;

	public WebElement getMyWishlistButton() {
		return driver.findElement(By.className("lnk_wishlist"));
	}

	public WebElement getMyPersonalInfoButton() {
		return driver.findElement(By.xpath("//*[@id=\"center_column\"]/div/div[1]/ul/li[4]/a"));
	}

	public WebElement getMyAddressesButton() {
		return driver.findElement(By.xpath("//*[@id=\"center_column\"]/div/div[1]/ul/li[3]/a"));
	}

	public MyAccountPage(WebDriver driver) {
		this.driver = driver;
	}

	public void navigateToMyAddress() {
		this.getMyAddressesButton().click();
	}

	public void clickOnPersonalInfo() {
		this.getMyPersonalInfoButton().click();
	}

	public void clickOnMyWishlist() {
		this.getMyWishlistButton().click();
	}
}
