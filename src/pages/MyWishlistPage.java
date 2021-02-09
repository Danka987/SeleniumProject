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

public void AssertWishlist() {
	List<WebElement>dynamicElement =  driver.findElements(By.id("block-history"));
	if (dynamicElement.size()!=0) {
		System.out.println("Wishlist is present");
	}
		else {
			System.out.println("Wishlist is not present");
		}
	}
	
	public void clickOnDelete() {
		this.getDeleteWishlistButton().click();
	}
}

