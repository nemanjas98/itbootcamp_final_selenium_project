package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignupPage {

	private WebDriver driver;
	private WebDriverWait wait;

	public SignupPage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;

	}
	
	public WebElement getNameInput() {
		return driver.findElement(By.id("name"));
	}
	
	public WebElement getEmailInput() {
		return driver.findElement(By.id("email"));
	}
	
	public WebElement getPasswordInput() {
		return driver.findElement(By.name("password"));
	}
	
	public WebElement getConfirmPasswordInput() {
		return driver.findElement(By.name("confirmPassword"));
	}
	
	public WebElement getSignUpButton() {
		return driver.findElement(By.className("v-btn--contained"));
	}
}
