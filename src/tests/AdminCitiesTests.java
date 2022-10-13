package tests;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AdminCitiesTests extends BasicTest{
	
	@Test (priority = 10)
	public void VisitsTheAdminCitiesPageAndListCities() {
		navPage.getLoginButton().click();
		loginPage.getEmailInput().sendKeys("admin@admin.com");
		loginPage.getPasswordInput().sendKeys("12345");
		loginPage.getLoginButton().click();
		loginPage.waitForSuccessfullLogIn();
		navPage.getAdminButton().click();
		navPage.getCitiesButton().click();
		Assert.assertTrue(driver.getCurrentUrl()
				.contains("/admin/cities"),
				"Url should contain '/admin/cities'");
	}
	
	@Test (priority = 20)
	public void ChecksInputTypesForCreateOrEditNewCity() {
		navPage.getAdminButton().click();
		navPage.getCitiesButton().click();
		citiesPage.getNewItemButton().click();
		citiesPage.waitForCreateOrEditDialogToBeVisible();
		Assert.assertTrue(citiesPage.getCityNameInput()
				.getAttribute("type")
				.equals("text"),
				"CityName: Value for the type attribute should be text");
	}
	
	@Test (priority = 30)
	public void CreateNewCity() {
		navPage.getAdminButton().click();
		navPage.getCitiesButton().click();
		citiesPage.getNewItemButton().click();
		citiesPage.waitForCreateOrEditDialogToBeVisible();
		citiesPage.getCityNameInput().sendKeys("Nemanja Stojanovic's city");
		citiesPage.getSaveCityButton().click();
		messagePopUpPage.waitForResponsePopUp();
		Assert.assertTrue(messagePopUpPage.getTextMessageFromCityPopUp()
				.getText()
				.contains("Saved successfully"),
				"PopUp should contain 'Saved successfully' text");
	}
	
	@Test (priority = 40)
	public void  EditCity() {
		navPage.getAdminButton().click();
		navPage.getCitiesButton().click();
		citiesPage.getSearchInput().sendKeys("Nemanja Stojanovic's city");
		citiesPage.waitForNumberOfRows(1);
		citiesPage.getEditButtonFromRow(1).click();
		citiesPage.waitForCreateOrEditDialogToBeVisible();
		citiesPage.getCityNameInput().sendKeys(Keys.CONTROL + "a");
		citiesPage.getCityNameInput().sendKeys(Keys.DELETE);
		citiesPage.getCityNameInput().sendKeys("Nemanja Stojanovic's city Edited");
		citiesPage.getSaveCityButton().click();
		messagePopUpPage.waitForResponsePopUp();
		Assert.assertTrue(messagePopUpPage.getTextMessageFromCityPopUp()
				.getText()
				.contains("Saved successfully"),
				"PopUp should contain 'Saved successfully' text");
	}
	
	@Test (priority = 50)
	public void SearchCity() {
		navPage.getAdminButton().click();
		navPage.getCitiesButton().click();
		citiesPage.getSearchInput().sendKeys("Nemanja Stojanovic's city Edited");
		citiesPage.waitForNumberOfRows(1);
		Assert.assertTrue(citiesPage.getCellFromTheTable(1, 2)
				.getText()
				.contains("Nemanja Stojanovic's city Edited"),
				"Table's value should be 'Nemanja Stojanovic's city Edited'");
	}


}
