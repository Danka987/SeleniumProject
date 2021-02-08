package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class IndexPage {

	WebDriver driver;
	WebElement signInButton;
	WebElement emailAddressField;
	WebElement passwordField;
	WebElement signIn;
	WebElement assertThatUserIsLoggedIn;
	
	public WebElement getAssertThatUserIsLoggedIn() {
		return driver.findElement(By.className("account"));
	}

	public WebElement getEmailAddressField() {
		return driver.findElement(By.id("email"));
	}

	public WebElement getPasswordField() {
		return driver.findElement(By.id("passwd"));
	}

	public WebElement getSignIn() {
		return driver.findElement(By.id("SubmitLogin"));
	}

	public WebElement getSignInButton() {
		return driver.findElement(By.className("login"));
	}

	public IndexPage(WebDriver driver) {
		this.driver = driver;
	}
	public void clickOnSignIn() {
		this.getSignInButton().click();
	}
	public void insertEmail(String email) {
		this.getEmailAddressField().clear();
		this.getEmailAddressField().sendKeys(email);
	}
	
	public void insertPassword(String password) {
		this.getPasswordField().sendKeys(password);
	}
	
	public void SignIn() {
		this.getSignIn().click();
	}
	
	public void assertText() {
		this.getAssertThatUserIsLoggedIn().getText();
	}
}
