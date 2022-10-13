package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BasicTest {
	
	@Test (priority = 10)
	public void visitsTheLoginPage () {
		
		navPage.getLanguagesButton().click();
		navPage.getEnButton().click();
		navPage.getLoginButton().click();
		
		Assert.assertTrue(driver.getCurrentUrl().contains("/login"),
				"ERROR: Url should contain /login.");
	}
	
	
	@Test(priority=20)
	public void checksInputTypes () {
		
		navPage.getLoginButton().click();
		
		Assert.assertEquals(loginPage.getEmailInput().getAttribute("type"), 
				              "email","ERROR - Input type should be email");
		
		Assert.assertEquals(loginPage.getPasswordInput().getAttribute("type"), 
				             "password", "ERROR - Input type should be a password");
	}
	
	
	@Test(priority=30)
	public void displaysErrorsWhenUserDoesNotExist () {
		
		navPage.getLoginButton().click();
		
		loginPage.getEmailInput().sendKeys("non-existing-user@gmal.com");
		loginPage.getPasswordInput().sendKeys("password123");
		loginPage.getLoginButton().click();
		
		messagePopUpPage.waitForPopUpToBeVisible();
		
		Assert.assertTrue(messagePopUpPage.getTextFromPopUpDialog().getText().equals("User does not exists"),
				          "ERROR - Message should be User does not exist.");
		
		Assert.assertTrue(driver.getCurrentUrl().contains("/login"), 
				          "ERROR - Url should contain /login.");
	}
	

	@Test(priority=40)
	public void displaysErrorsWhenPasswordIsWrong () {
		
		navPage.getLoginButton().click();
		
		loginPage.getEmailInput().sendKeys("admin@admin.com");
		loginPage.getPasswordInput().sendKeys("password123");
		loginPage.getLoginButton().click();
		
		messagePopUpPage.waitForPopUpToBeVisible();
		
		Assert.assertTrue(messagePopUpPage.getTextFromPopUpDialog().getText().equals("Wrong password"), 
				          "ERROR - Message should be Wrong password");
		
		Assert.assertTrue(driver.getCurrentUrl().contains("/login"), 
				          "ERROR: Url should contain /login.");
	}
	
	
	@Test(priority=50)
	public void login () throws InterruptedException {
		
		navPage.getLoginButton().click();
		
		loginPage.getEmailInput().sendKeys("admin@admin.com");
		loginPage.getPasswordInput().sendKeys("12345");
		loginPage.getLoginButton().click();
		Thread.sleep(1000);
		
		Assert.assertTrue(driver.getCurrentUrl().contains("/home"), 
				          "ERROR - Url should contain '/home'");
	}
	

	@Test(priority=60)
	public void logout() {
		
		Assert.assertTrue(navPage.getLogoutButton().isDisplayed(), 
				          "ERROR - Logout button is not displayed.");
		
		navPage.getLogoutButton().click();
	}
}
