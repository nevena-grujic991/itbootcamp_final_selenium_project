package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CitiesPage {

	private WebDriver driver;
	private WebDriverWait wait;
	
	public CitiesPage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
	}
	public WebElement getNewItemButton () {
		return driver.findElement(By.xpath("//button[contains(@class, 'btnNewItem')]"));
	}
	
	public WebElement getSearchInput () {
        return driver.findElement(By.id("search"));
}
	public void waitForDialogForEditAndCreateToAppear () {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("dlgNewEditItem ")));
	}
	
	public void waitForDialogForDeleteToAppear () {
	   wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()=' Cancel ']")));
	}
	
	public WebElement getInputFromNewItemDialog() {
		return driver.findElement(By.name("name"));
	}
	
	public WebElement getSaveButton() {
		return driver.findElement(By.xpath("//button[contains(@class, 'btnSave')]"));
	}
	public WebElement getDeleteButton() {
		return driver.findElement(By.xpath("//*[text()=' Delete ']"));
	}
	
	public void waitForNumbersOfCitiesToBe ( int rows) {
		wait.until(ExpectedConditions.numberOfElementsToBe(By.xpath("//*[contains(@class, 'v-data-table__wrapper')]//tbody/tr"), rows));
}
	public WebElement getCell(int row, int column) {
		return driver.findElement(By.xpath("//tbody/tr['" + row + "']/td['" + column + "']"));
	}
	
	public WebElement getEditButtonFromRow(int row) {
		return driver.findElement(By.xpath("//tbody/tr['" + row + "']/td[1]/div/button[1]"));
	}
	
	public WebElement getDeleteButtonFromRow(int row) {
		return driver.findElement(By.xpath("//tbody/tr['" + row + "']/td[1]/div/button[2]"));
	}
}
	
