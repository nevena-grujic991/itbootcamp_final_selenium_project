package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SignupTests extends BasicTest {
	
	@Test (priority=10)
	public void visitsTheSignupPage () {
		
		navPage.getSignUpButton().click();
		Assert.assertTrue(driver.getCurrentUrl().endsWith("/signup"), 
				          "ERROR - Url should contain /signup.");
	}
	
	
	@Test (priority=20)
	public void checksInputTypes () {
		
		navPage.getSignUpButton().click();
		
		Assert.assertEquals(signupPage.getEmail().getAttribute("type"), "email", 
				            "ERROR - Type of input should be an email");
		
		Assert.assertEquals(signupPage.getPassword().getAttribute("type"), "password",
				            "ERROR - Type of input should be password"); 
		
		Assert.assertEquals(signupPage.getConfirmPassword().getAttribute("type"), "password",
				             "ERROR - Type of input should be password");  
		
	}
	
	
	@Test (priority=30)
	public void displaysErrorsWhenUserAlreadyExists () {
		
		navPage.getSignUpButton().click();
		
		Assert.assertTrue(driver.getCurrentUrl().endsWith("/signup"), 
				          "ERROR - Url should contain /signup.");
		
		signupPage.getName().sendKeys("Another User");
		signupPage.getEmail().sendKeys("admin@admin.com");
		signupPage.getPassword().sendKeys("12345");
		signupPage.getConfirmPassword().sendKeys("12345");
		signupPage.getSignMeUpButton().click();
		
		messagePopUpPage.waitForPopUpToBeVisible();
		Assert.assertTrue(messagePopUpPage.getTextFromPopUpDialog().getText().equals("E-mail already exists"), 
				          "ERROR - Unexpected message");
	}
	
	
	@Test (priority=40)
	public void signup() throws InterruptedException {
		
		navPage.getSignUpButton().click();
		
		signupPage.getName().sendKeys("Nevena Grujic");
		signupPage.getEmail().sendKeys("nevena.grujic@itbootcamp.rs");
		signupPage.getPassword().sendKeys("12345");
		signupPage.getConfirmPassword().sendKeys("12345");
		signupPage.getSignMeUpButton().click();
		
		Thread.sleep(1000);
		
		Assert.assertTrue(messagePopUpPage.getMessageFromVerifyYourAccount().getText().equals("IMPORTANT: Verify your account"), 
				          "ERROR - Unexpected message");
		
		messagePopUpPage.getCloseButtonFromVerifyAccountDialog().click();
		navPage.getLogoutButton().click();
	}

}
