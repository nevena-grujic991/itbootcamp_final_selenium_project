package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MessagePopUpPage {
	
	private WebDriver driver;
	private WebDriverWait wait;
	
	public MessagePopUpPage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
	}
	
	public void waitForPopUpToBeVisible () {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("error")));
		
	}
	
	public void waitForSavedSuccessfulyMessage() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()=' Saved successfully ']")));
	}
	
	public WebElement getTextFromPopUpDialog () {
		return driver.findElement(By.xpath("//*[contains(@class, 'error')]//ul/li"));
	}
	
	public WebElement getSavedSuccessfulMessages() {
		return driver.findElement(By.className("success"));
	}
	
	public void waitForSuccessfullSavedMessages() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("success")));
	}
	
	public WebElement getCloseButton () {
		return driver.findElement(By.xpath("//*[text()='Close']/.."));
	}
	
	public void waitForVerifyYourAccountDialogToAppear () {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("dlgVerifyAccount")));
	}
	
	public WebElement getMessageFromVerifyYourAccount () {
		return driver.findElement(By.xpath("//*[text()=' IMPORTANT: Verify your account ']"));
	}
	
	public WebElement getCloseButtonFromVerifyAccountDialog () {
		return driver.findElement(By.xpath("//button[contains(@class, 'btnClose')]"));
	}
	
}
