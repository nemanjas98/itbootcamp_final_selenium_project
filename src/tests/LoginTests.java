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
	
	@Test (priority = 30)
	public void DisplaysErrorsWhenUserDoesNotExist() {
		navPage.getLoginButton().click();
		loginPage.getEmailInput().sendKeys("non-existing-user@gmal.com");
		loginPage.getPasswordInput().sendKeys("password123");
		loginPage.getLoginButton().click();
		messagePopUpPage.waitForPopUpToBeVisible();
		Assert.assertTrue(messagePopUpPage.getTextMessageFromPopUp()
				.getText()
				.contains("User does not exists"),
				"PopUp should contain 'User does not exists' text");
		Assert.assertTrue(driver.getCurrentUrl()
				.contains("/login"),
				"Url should contain '/login'");
	}
	
	@Test (priority = 40)
	public void DisplaysErrorsWhenPasswordIsWrong() {
		navPage.getLoginButton().click();
		loginPage.getEmailInput().sendKeys("admin@admin.com");
		loginPage.getPasswordInput().sendKeys("password123");
		loginPage.getLoginButton().click();
		messagePopUpPage.waitForPopUpToBeVisible();
		Assert.assertTrue(messagePopUpPage.getTextMessageFromPopUp()
				.getText()
				.contains("Wrong password"),
				"PopUp should contain 'Wrong password' text");
		Assert.assertTrue(driver.getCurrentUrl()
				.contains("/login"),
				"Url should contain '/login'");
	}
	
	@Test (priority = 50)
	public void Login() {
		navPage.getLoginButton().click();
		loginPage.getEmailInput().sendKeys("admin@admin.com");
		loginPage.getPasswordInput().sendKeys("12345");
		loginPage.getLoginButton().click();
		loginPage.waitForSuccessfullLogIn();
		Assert.assertTrue(driver.getCurrentUrl()
				.contains("/home"),
				"Url should contain '/home'");
	}
	
	@Test (priority = 60)
	public void Logout() {
		Assert.assertTrue(navPage.getLogoutButton()
				.isDisplayed(),
				"Logout button should be displayed");
		navPage.getLogoutButton().click();
	}
}
