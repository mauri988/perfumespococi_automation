package pages;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

	protected WebDriver driver;
	private WebDriverWait wait;

	public BasePage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 10);
	}

	public void clearOnElement(WebElement element) {
		element.clear();
	}

	public void typeOnElement(WebElement element, String text) {
		element.clear();
		element.sendKeys(text);
	}

	public void clickOnElement(WebElement element) {
		wait.until(ExpectedConditions.elementToBeClickable(element)).click();
	}

	public void waitUntilClickeable(WebElement element, int sec) {
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public void onSelectableElement(WebElement element, String text, int sec) {
		(new WebDriverWait(driver, sec)).until(ExpectedConditions.elementToBeClickable(element));
		(new Select(element)).selectByVisibleText(text);
	}

	public void switchToTab() {
		String baseTab = driver.getWindowHandle();
		Set<String> newTab = driver.getWindowHandles();

		for (String handle : newTab) {
			if (!handle.equals(baseTab)) {
				driver.switchTo().window(handle);
			}
		}
	}

	public void acceptAlert() {
		wait.until(ExpectedConditions.alertIsPresent()).accept();
	}

	public void dismissAlert() {
		wait.until(ExpectedConditions.alertIsPresent()).dismiss();
	}
}
