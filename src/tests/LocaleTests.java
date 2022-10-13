package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LocaleTests extends BasicTest{
	
	@Test(priority=10)
	public void setLocaleToEs() {
		
		navPage.getLanguagesButton().click();
		navPage.getEsButton().click();
		
		Assert.assertTrue(driver.findElement(By.tagName("h1")).getText().contains("Página de aterrizaje"),
				          "ERROR - Unexpected text");
	}
	
	@Test(priority=20)
	public void setLocaleToEn() {
		
		navPage.getLanguagesButton().click();
		navPage.getEnButton().click();
		
		Assert.assertTrue(driver.findElement(By.tagName("h1")).getText().contains("Landing"),
				          "ERROR - Unexpected text");
	}
	
	@Test(priority=30)
	public void setLocaleToCn() {
		
		navPage.getLanguagesButton().click();
		navPage.getCnButton().click();
		
		Assert.assertTrue(driver.findElement(By.tagName("h1")).getText().contains("首页"),
				          "ERROR - Unexpected text");
	}
	
	@Test(priority=40)
	public void setLocaleToFr() {
		
		navPage.getLanguagesButton().click();
		navPage.getFrButton().click();
		
		Assert.assertTrue(driver.findElement(By.tagName("h1")).getText().contains("Page d'atterrissage"), 
		                  "ERROR - Unexpected text");
	}
}
