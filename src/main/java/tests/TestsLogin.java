package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.LoginPage;

public class TestsLogin {
	String url = "http://localhost/perfumespococi/";
	WebDriver driver;

	@BeforeMethod
	public void setUpDriver() {
		driver = new FirefoxDriver();
		driver.manage().window().fullscreen();
		driver.get(url);
	}

	@Test
	public void testLogin() {
		String user = "paul";
		String pwd = "canastos123";

		LoginPage loginPage = new LoginPage(driver);
		loginPage.doLogin(user, pwd);

		driver.quit();
	}
}
