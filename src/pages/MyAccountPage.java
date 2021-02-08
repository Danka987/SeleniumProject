package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MyAccountPage {
  WebDriver driver;
  WebElement myAddressesButton;
  
  
  public WebElement getMyAddressesButton() {
	return driver.findElement(By.xpath("//*[@id=\"center_column\"]/div/div[1]/ul/li[3]/a"));
}


public MyAccountPage(WebDriver driver) {
		this.driver = driver;
	}

public void navigateToMyAddress() {
	this.getMyAddressesButton().click();
}
}
