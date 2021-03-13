package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AssertHomePage extends BasePage {
	@FindBy(xpath = "/html/body/div[3]/div[2]/div[1]/ul/li/a[1]")
	WebElement navUserName;

	public AssertHomePage(WebDriver driver) {
		super(driver);
	}

	public boolean isDisplayed() {
		return navUserName.isDisplayed();
	}
}
