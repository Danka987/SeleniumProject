package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MyAddressesPage {
WebDriver driver;
WebElement updateButton;
WebElement adressField2;
WebElement saveButton;
WebElement textToAssert;


public WebElement getTextToAssert() {
	return driver.findElement(By.xpath("//*[@id=\"center_column\"]/div[1]/p[1]/strong"));
}

public WebElement getSaveButton() {
	return driver.findElement(By.id("submitAddress"));
}

public WebElement getAdressField2() {
	return driver.findElement(By.id("address2"));
}

public WebElement getUpdateButton() {
	return driver.findElement(By.xpath("//*[@id=\"center_column\"]/div[1]/div/div/ul/li[9]/a[1]"));
}

public MyAddressesPage(WebDriver driver) {
	this.driver = driver;
}

public void clickOnUpdate() {
	this.getUpdateButton().click();
}

public void inputAddress2 (String adress2) {
	this.getAdressField2().sendKeys(adress2);
}
public void saveUpdates() {
	this.getSaveButton().click();
}
}
