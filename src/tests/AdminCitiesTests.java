package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AdminCitiesTests extends BasicTest {
	
	@Test(priority=10)
	public void visitsTheAdminCitiesPageAndListCities() {
		
		navPage.getLoginButton().click();
		loginPage.getEmailInput().sendKeys("admin@admin.com");
		loginPage.getPasswordInput().sendKeys("12345");
		loginPage.getLoginButton().click();
		
		navPage.getAdminButton().click();
		navPage.getAdminCitiesLink().click();
		
		Assert.assertTrue(driver.getCurrentUrl().contains("/admin/cities"), 
				          "ERROR - Url does not contain /admin/cities");
}
	@Test(priority=20)
	public void checksInputTypesForCreateEditNewCity() {
		
		navPage.getAdminButton().click();
		navPage.getAdminCitiesLink().click();
		
		citiesPage.getNewItemButton().click();
		citiesPage.waitForDialogForEditAndCreateToAppear();
		
		Assert.assertEquals(citiesPage.getInputFromNewItemDialog().getAttribute("type"), "text",
				            "ERROR - Type attribute is not text");
	}
	
	
	@Test(priority=30)
	public void createNewCity() {
		
		navPage.getAdminButton().click();
		navPage.getAdminCitiesLink().click();
		
		citiesPage.getNewItemButton().click();
		citiesPage.waitForDialogForEditAndCreateToAppear();
		citiesPage.getInputFromNewItemDialog().sendKeys("Nevena Grujic's city");
		citiesPage.getSaveButton().click();
		
	    messagePopUpPage.waitForSavedSuccessfulyMessage();
	    Assert.assertTrue(messagePopUpPage.getSavedSuccessfulMessages().getText().contains("Saved successfully"), 
	    		          "ERROR - Message is not saved successfully");
	}
	
	@Test(priority=40)
	public void editCity() {
		
		navPage.getAdminButton().click();
		navPage.getAdminCitiesLink().click();
		citiesPage.getSearchInput().sendKeys("Nevena Grujic's city");
		
		citiesPage.waitForNumbersOfCitiesToBe(1);
		citiesPage.getEditButtonFromRow(1).click();
		citiesPage.getInputFromNewItemDialog().sendKeys("Nevena Grujic's city Edited");
		citiesPage.getSaveButton().click();
		
		messagePopUpPage.waitForSuccessfullSavedMessages();
		
		Assert.assertTrue(messagePopUpPage.getSavedSuccessfulMessages().getText().contains("Saved successfully"), 
				          "ERROR - Message is not saved successfully");
	}
	
	@Test(priority=50)
	public void searchCity() {
		
		navPage.getAdminButton().click();
		navPage.getAdminCitiesLink().click();
		
		citiesPage.getSearchInput().sendKeys("Nevena Grujic's city");
		citiesPage.waitForNumbersOfCitiesToBe(1);
		
		
		Assert.assertTrue(citiesPage.getCell(1, 2).getText().contains("Nevena Grujic's city"), 
				          "ERROR - Unexpected city name");
	}
	
	@Test(priority=60)
	public void deleteCity() {
		
		navPage.getAdminButton().click();
		navPage.getAdminCitiesLink().click();
		
		citiesPage.getSearchInput().sendKeys("Nevena Grujic's city");
		citiesPage.waitForNumbersOfCitiesToBe(1);
		
		
		Assert.assertTrue(citiesPage.getCell(1, 2).getText().contains("Nevena Grujic's city"),
				          "ERROR - Unexpected city name" );
		
		citiesPage.getDeleteButtonFromRow(1).click();
		citiesPage.waitForDialogForDeleteToAppear();
		citiesPage.getDeleteButton().click();
		messagePopUpPage.waitForSuccessfullSavedMessages();
		
		Assert.assertTrue(messagePopUpPage.getSavedSuccessfulMessages().getText().contains("Deleted successfully"),
				          "ERROR - Wrong message");
	}
	}
