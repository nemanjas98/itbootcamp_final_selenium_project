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
	


}
