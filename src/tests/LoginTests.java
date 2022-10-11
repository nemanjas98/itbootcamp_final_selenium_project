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
	
	@Test (priority = 20)
	public void ChecksInputTypes() {
		navPage.getLoginButton().click();
		Assert.assertTrue(loginPage.getEmailInput()
				.getAttribute("type")
				.equals("email"),
				"Value for the type attribute should be email");
		Assert.assertTrue(loginPage.getPasswordInput()
				.getAttribute("type")
				.equals("password"),
				"Value for the type attribute should be password");	
	}
}
