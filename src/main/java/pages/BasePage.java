package pages;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	WebDriver driver;

	public BasePage(WebDriver driver) {
		this.driver = driver;
	}

	public void typeOnElement(WebElement element, String text) {
		element.sendKeys(text);
	}

	public void clickOnElement(WebElement element) {
		element.click();
	}

	public void clearOnElement(WebElement element) {
		element.clear();
	}
	
	public void waitUntilClickeable(WebElement element, int sec) {
		WebDriverWait wait = new WebDriverWait(driver, sec);
		wait.until(ExpectedConditions.elementToBeClickable(element)).click();
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
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.alertIsPresent()).accept();
	}

	public void dismissAlert() {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.alertIsPresent()).dismiss();
	}
}
