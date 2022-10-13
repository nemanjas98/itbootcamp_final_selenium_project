package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CitiesPage {

	private WebDriver driver;
	private WebDriverWait wait;

	public CitiesPage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;

	}
	
	public WebElement getNewItemButton() {
		return driver.findElement(By.className("btnNewItem"));
	}
	
	public WebElement getCityNameInput() {
		return driver.findElement(By.id("name"));
	}
	
	public WebElement getSearchInput() {
		return driver.findElement(By.id("search"));
	}
	
	public void waitForCreateOrEditDialogToBeVisible() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class = 'v-card v-sheet theme--light']")));
	}
	
	public void waitForDeleteDialogToBeVisible() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class = 'v-card v-sheet theme--light rounded-0']")));
	}
	
	public WebElement getSaveCityButton() {
		return driver.findElement(By.className("btnSave"));
	}
	
	public WebElement getDeleteCityButton() {
		return driver.findElement(By.xpath("//*[contains(@class,'v-btn__content') and contains(text(),'Delete')]"));
	}
	
	public void waitForNumberOfRows(int rowNumber) {
		wait.until(ExpectedConditions.numberOfElementsToBe(
					By.xpath("//tbody/tr"), rowNumber));
	}
	
	public WebElement getCellFromTheTable(int rowNumber, int columnNumber) {
		return driver.findElement(By.xpath("//tbody/tr[" + rowNumber + "]/td[" + columnNumber + "]"));
	}
	
	public WebElement getEditButtonFromRow(int rowNumber) {
		return driver.findElement(By.xpath("//tbody/tr[" + rowNumber + "]//button[@id='edit']"));
	}
	
	public WebElement getDeleteButtonFromRow(int rowNumber) {
		return driver.findElement(By.xpath("//tbody/tr[" + rowNumber + "]//div/button[2]"));
	}
	
	
}
