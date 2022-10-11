package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MessagePopUpPage {
	
	private WebDriver driver;
	private WebDriverWait wait;

	public MessagePopUpPage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
	}
	
	public void waitForPopUpToBeVisible() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'v-snack__wrapper')]")));
	}
	
	public WebElement getTextMessageFromPopUp() {
		return driver.findElement(By.className("v-snack__content"));
	}
	
	public void waitForResponsePopUp() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("success")));
	}
	
	public void getCloseButtonFromResponsePopUp() {
		driver.findElement(By.xpath("//*[contains(@class,'v-snack__content')]//button"));
	}
	
	public void waitForVerifyAccountPopUp() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("dlgVerifyAccount")));
	}
	
	public WebElement getHeaderMessageFromVerifyPopUp() {
		return driver.findElement(By.xpath("//div[contains(@class, 'v-card__title')]"));
	}
	
	public WebElement getCloseButtonFromVerifyAccountPopUp() {
		return driver.findElement(By.className("btnClose"));
	}
	
	
	

}
