package pages;

import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

	protected WebDriver driver;
	private WebDriverWait wait;
	private static final Logger logger = LogManager.getLogger();

	public BasePage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 20);
	}

	public void clearOnElement(WebElement element) {
		try {
			element.clear();
		} catch (Exception e) {
			logger.error("Unable to click on element: " + e);
		}
	}

	public void typeOnElement(WebElement element, String text) {
		try {
			element.clear();
			element.sendKeys(text);
		} catch (Exception e) {
			logger.error("Unable to click on element: " + e);
		}
	}

	public void clickOnElement(WebElement element) {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(element)).click();
		} catch (Exception e) {
			logger.error("Unable to click on element: " + e);
		}
	}

	public void waitUntilClickeable(WebElement element) {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(element));
		} catch (Exception e) {
			logger.error("Unable to click on element: " + e);
		}
	}

	public void onSelectableElement(WebElement element, String text, int sec) {
		try {
			(new WebDriverWait(driver, sec)).until(ExpectedConditions.elementToBeClickable(element));
			(new Select(element)).selectByVisibleText(text);
		} catch (Exception e) {
			logger.error("Unable to click on element: " + e);
		}
	}

	public void switchToTab() {
		try {
			String baseTab = driver.getWindowHandle();
			Set<String> newTab = driver.getWindowHandles();

			for (String handle : newTab) {
				if (!handle.equals(baseTab)) {
					driver.switchTo().window(handle);
				}
			}
		} catch (Exception e) {
			logger.error("Unable to click on element: " + e);
		}
	}

	public void acceptAlert() {
		try {
			wait.until(ExpectedConditions.alertIsPresent()).accept();
		} catch (Exception e) {
			logger.error("Unable to click on element: " + e);
		}
	}

	public void dismissAlert() {
		try {
			wait.until(ExpectedConditions.alertIsPresent()).dismiss();
		} catch (Exception e) {
			logger.error("Unable to click on element: " + e);
		}
	}
	
}
