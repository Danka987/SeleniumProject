package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PersonalInfoPage {
WebDriver driver;
WebElement lastNameField;
WebElement SaveButton;
WebElement passwordField;
WebElement messageToAssert;


public WebElement getMessageToAssert() {
	return driver.findElement(By.xpath("//*[@id=\"center_column\"]/div/p"));
}


public WebElement getPasswordField() {
	return driver.findElement(By.id("old_passwd"));
}


public WebElement getSaveButton() {
	return driver.findElement(By.name("submitIdentity"));
}


public WebElement getLastNameField() {
	return driver.findElement(By.id("lastname"));
}


public PersonalInfoPage(WebDriver driver) {
	this.driver = driver;
}
public void clickOnSave() {
	this.getSaveButton().click();
}



}
