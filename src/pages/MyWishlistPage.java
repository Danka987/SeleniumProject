package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MyWishlistPage {
	WebDriver driver;
	WebElement wishListNameField;
	WebElement saveButton;
	WebElement deleteWishlistButton;

	List<WebElement> Wishlist;

	List<WebElement> getWishlist() {
		return driver.findElements(By.tagName("tr"));
	}

	public int countWishlists() {
		System.out.println(getWishlist().size());
		return getWishlist().size();
	}

	public void addWishlist(String listName) {
		getWishListNameField().sendKeys(listName);
		getSaveButton().click();
	}

	public WebElement getDeleteWishlistButton() {
		return driver.findElement(By.className("icon"));
	}

	public WebElement getSaveButton() {
		return driver.findElement(By.id("submitWishlist"));
	}

	public WebElement getWishListNameField() {
		return driver.findElement(By.id("name"));
	}

	public MyWishlistPage(WebDriver driver) {
		this.driver = driver;
	}

	public void ClickOnSave() {
		this.getSaveButton().click();
	}

	public void clickOnDelete() {
		this.getDeleteWishlistButton().click();
	}

}
