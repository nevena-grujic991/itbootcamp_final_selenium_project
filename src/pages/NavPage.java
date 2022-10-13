package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NavPage {

	private WebDriver driver;
	private WebDriverWait wait;
	
	public NavPage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
	}
	public WebElement getHomeLink () {
		return driver.findElement(By.xpath("//a[@href='/']"));
	}
	
	public WebElement getAboutLink () {
		return driver.findElement(By.xpath("//a[@href='/about']"));
	}
	
	public WebElement getMyProfileLink () {
		return driver.findElement(By.xpath("//a[@href='/profile']"));
	}
	
	public WebElement getAdminButton () {
		return driver.findElement(By.className("btnAdmin"));
	}
	
	public WebElement getAdminCitiesLink () {
		return driver.findElement(By.className("btnAdminCities"));
	}
	
	public WebElement getAdminUsersLink () {
		return driver.findElement(By.className("btnAdminUsers"));
	}

     public WebElement getSignUpButton () {
	   return driver.findElement(By.xpath("//*[contains(@class, 'v-btn--router')][4]/span"));
}
	public WebElement getLoginButton () {
	    return driver.findElement(By.xpath("//*[contains(@class, 'v-btn--router')][3]/span"));
	}
	
	public WebElement getLogoutButton () {
		return driver.findElement(By.xpath("//button[contains(@class, 'btnLogout')]"));
	}
	
	public WebElement getLanguagesButton () {
		return driver.findElement(By.xpath("//button[contains(@class, 'btnLocaleActivation')]"));
	}
	
	public WebElement getEnButton () {
		return driver.findElement(By.xpath("//*[text()='EN']"));
	}
	
	public WebElement getEsButton () {
		return driver.findElement(By.xpath("//*[text()='ES']"));
	}
	
	public WebElement getFrButton () {
		return driver.findElement(By.xpath("//*[text()='FR']"));
	}
	
	public WebElement getCnButton () {
		return driver.findElement(By.xpath("//*[text()='CN']"));
}
	
	}
