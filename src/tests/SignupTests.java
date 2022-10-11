package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SignupTests extends BasicTest{
	
	@Test (priority = 10)
	public void VisitsTheSignupPage() {
		navPage.getSignUpButton().click();
		Assert.assertTrue(driver.getCurrentUrl()
				.contains("/signup"),
				"Url should contain '/signup'");
	}
	
	@Test (priority = 20)
	public void ChecksInputTypes() {
		navPage.getSignUpButton().click();
		Assert.assertTrue(signupPage.getEmailInput()
				.getAttribute("type")
				.equals("email"),
				"eMail: Value for the type attribute should be email");
		Assert.assertTrue(signupPage.getPasswordInput()
				.getAttribute("type")
				.equals("password"),
				"Password: Value for the type attribute should be password");
		Assert.assertTrue(signupPage.getConfirmPasswordInput()
				.getAttribute("type")
				.equals("password"),
				"ConfirmPassword: Value for the type attribute should be password");
	}
	
	@Test (priority = 30)
	public void DisplaysErrorsWhenUserAlreadyExists() {
		navPage.getSignUpButton().click();
		Assert.assertTrue(driver.getCurrentUrl()
				.contains("/signup"),
				"Url should contain '/signup'");
		signupPage.getNameInput().sendKeys("Another User");
		signupPage.getEmailInput().sendKeys("admin@admin.com");
		signupPage.getPasswordInput().sendKeys("12345");
		signupPage.getConfirmPasswordInput().sendKeys("12345");
		signupPage.getSignUpButton().click();
		messagePopUpPage.waitForPopUpToBeVisible();
		Assert.assertTrue(messagePopUpPage.getTextMessageFromPopUp()
				.getText()
				.contains("E-mail already exists"),
				"PopUp should contain 'E-mail already exists' text");
		Assert.assertTrue(driver.getCurrentUrl()
				.contains("/signup"),
				"Url should contain '/signup'");
	}
	
}
