package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NavPage {

	private WebDriver driver;
	private WebDriverWait wait;

	public NavPage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;

	}

	public WebElement getHomeButton() {
		return driver.findElement(By.xpath("//*[contains(@class,'v-btn__content') and contains(text(),'Home')]"));
	}

	public WebElement getAboutButton() {
		return driver.findElement(By.xpath("//*[contains(@class,'v-btn__content') and contains(text(),'About')]"));
	}

	public WebElement getMyProfileButton() {
		return driver.findElement(By.xpath("//*[contains(@class,'v-btn__content') and contains(text(),'My Profile')]"));
	}

	public WebElement getAdminButton() {
		return driver.findElement(By.className("btnAdmin"));
	}

	public WebElement getCitiesButton() {
		return driver.findElement(By.className("btnAdminCities"));
	}

	public WebElement getUsersButton() {
		return driver.findElement(By.className("btnAdminUsers"));
	}
	
	public WebElement getSignUpButton() {
		return driver.findElement(By.xpath("//*[contains(@class,'v-btn__content') and contains(text(),'Sign Up')]"));
	}

	public WebElement getLoginButton() {
		return driver.findElement(By.className("btnLogin"));
	}

	public WebElement getLogoutButton() {
		return driver.findElement(By.className("btnLogout"));
	}

	public WebElement getLanguageButton() {
		return driver.findElement(
				By.xpath("//*[@class = 'btnLocaleActivation v-btn v-btn--text theme--light v-size--default']"));
	}

	public WebElement getEnglishLanguageButton() {
		return driver.findElement(By.className("btnEN"));
	}

	public WebElement getSpanishLanguageButton() {
		return driver.findElement(By.className("btnES"));
	}

	public WebElement getFrenchLanguageButton() {
		return driver.findElement(By.className("btnFR"));
	}

	public WebElement getChineseLanguageButton() {
		return driver.findElement(By.className("btnCN"));
	}

	public WebElement getUkranianLanguageButton() {
		return driver.findElement(By.className("btnUA"));
	}
	
	public WebElement getHeaderText() {
		return driver.findElement(By.tagName("h1"));
	}

}
