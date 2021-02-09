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
	WebElement assertThatUserIsNotLoggedIn;
    WebElement logOutButton;
    WebElement assertForEmptyFields;
	
	

	
	

	public WebElement getAssertForEmptyFields() {
		return driver.findElement(By.xpath("//*[@id=\"center_column\"]/div[1]/ol/li"));
	}

	public WebElement getLogOutButton() {
		return driver.findElement(By.className("logout"));
	}

	public WebElement getAssertThatUserIsNotLoggedIn() {
		return driver.findElement(By.className("alert-danger"));
	}

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
	public void logIn(String email, String password) {
		this.getSignInButton().click();
		this.getEmailAddressField().sendKeys(email);
		this.getPasswordField().sendKeys(password);
		this.getSignIn().click();
	}
	public void SignIn() {
		this.getSignIn().click();
	}
	
	public void assertText() {
		this.getAssertThatUserIsLoggedIn().getText();
	}
	
	public void assertText2() {
		this.getAssertThatUserIsNotLoggedIn().getText();
	}
	
	public void logOut() {
		this.getLogOutButton().click();
	}
}
