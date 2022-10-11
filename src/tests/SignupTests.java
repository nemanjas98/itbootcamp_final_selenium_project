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
	
}
