package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignupPage {
	
		private WebDriver driver;
		private WebDriverWait wait;
		
		public SignupPage(WebDriver driver, WebDriverWait wait) {
			this.driver = driver;
			this.wait = wait;
		}

		public WebElement getName () {
			return driver.findElement(By.id("name"));
		}
		
		public WebElement getEmail () {
			return driver.findElement(By.name("email"));
		}
		
		public WebElement getPassword () {
			return driver.findElement(By.name("password"));
		}
		
		public WebElement getConfirmPassword () {
			return driver.findElement(By.id("confirmPassword"));
		}
		
		public WebElement getSignMeUpButton () {
			return driver.findElement(By.xpath("//*[text()='Sign me up']"));
		}
}
