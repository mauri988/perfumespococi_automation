package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {

	@FindBy(id = "login")
	WebElement usernameField;
	
	@FindBy(id = "password")
	WebElement passwordField;
	
	@FindBy(id = "submit")
	WebElement btnLogin;

	WebDriver driver;

	public LoginPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public void doLogin(String user, String pwd) {
		typeOnElement(usernameField, user);
		typeOnElement(passwordField, pwd);
		clickOnElement(btnLogin);
	}
}
