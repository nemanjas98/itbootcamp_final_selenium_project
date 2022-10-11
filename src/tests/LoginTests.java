package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BasicTest{

	
	@Test (priority = 10)
	public void VisitsTheLoginPage() {
		navPage.getLanguageButton().click();
		navPage.getEnglishLanguageButton().click();
		navPage.getLoginButton().click();
		Assert.assertTrue(driver.getCurrentUrl()
				.contains("/login"),
				"Url should contain '/login'");
	}
}
