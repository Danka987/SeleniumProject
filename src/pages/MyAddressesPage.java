package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MyAddressesPage {
	WebDriver driver;
	WebElement updateButton;
	WebElement adressField2;
	WebElement saveButton;
	WebElement textToAssert;
	WebElement addNewAddressButton;
	WebElement stateBar;
	WebElement addressField;
	WebElement cityField;
	WebElement alabama;
	WebElement postcodeField;
	WebElement phoneField;
	WebElement aliasAddress;
	WebElement forAssertNewAddres;
	WebElement deleteAddressButton;

	public WebElement getDeleteAddressButton() {
		return driver.findElement(By.xpath("//*[@id=\"center_column\"]/div[1]/div/div[2]/ul/li[9]/a[2]"));
	}

	public WebElement getForAssertNewAddres() {
		return driver.findElement(By.xpath("//*[@id=\"center_column\"]/div[1]/div/div[2]/ul/li[1]/h3"));
	}

	public WebElement getAliasAddress() {
		return driver.findElement(By.id("alias"));
	}

	public WebElement getPhoneField() {
		return driver.findElement(By.id("phone"));
	}

	public WebElement getPostcodeField() {
		return driver.findElement(By.id("postcode"));
	}

	public WebElement getAlabama() {
		return driver.findElement(By.xpath("//*[@id=\"id_state\"]/option[2]"));
	}

	public WebElement getCityField() {
		return driver.findElement(By.id("city"));
	}

	public WebElement getAddressField() {
		return driver.findElement(By.id("address1"));
	}

	public WebElement getStateBar() {
		return driver.findElement(By.id("id_state"));
	}

	public WebElement getAddNewAddressButton() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		return driver.findElement(By.xpath("//*[@id=\"center_column\"]/div[2]/a"));
	}

	public WebElement getTextToAssert() {
		return driver.findElement(By.xpath("//*[@id=\"center_column\"]/div[1]/div/div[1]/ul/li[4]/span[2]"));
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

	public void inputAddress2(String adress2) {
		this.getAdressField2().sendKeys(adress2);
	}

	public void saveUpdates() {
		this.getSaveButton().click();
	}

	public void clickOnNewAddressButton() {
		this.getAddNewAddressButton().click();
	}

	public void clickOnStateBar() {
		this.getStateBar().click();
	}

	public void chooseState() {
		this.getAlabama().click();
	}

	public void deleteAddress() {
		this.getDeleteAddressButton().click();
	}

}
