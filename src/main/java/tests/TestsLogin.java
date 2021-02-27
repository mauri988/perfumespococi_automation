package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.LoginPage;

public class TestsLogin {
	public static String url = "http://localhost/perfumespococi/";
	private WebDriver driver;

	@BeforeMethod
	public void setUpDriver() {
		driver = new FirefoxDriver();
		//driver.manage().window().fullscreen();
		driver.get(url);
	}

	@Test(priority = 0)
	public void testLogin() {
		String user = "paul";
		String pwd = "canastos123";

		LoginPage loginPage = new LoginPage(driver);
		loginPage.doLogin(user, pwd);
		//driver.quit();

	}

	@Test(priority = 1)
	public void testIncorrectPassword() {
		String user = "paul";
		String pwd = "auto123";

		LoginPage loginPage = new LoginPage(driver);
		loginPage.doLogin(user, pwd);
		//driver.quit();

	}

	@Test(priority = 2)
	public void testIncorrectUsername() {
		String user = "test";
		String pwd = "canastos123";

		LoginPage loginPage = new LoginPage(driver);
		loginPage.doLogin(user, pwd);
		//driver.quit();

	}
	
	@Test(priority = 3)
	public void testIncorrectCredentials() {
		String user = "test";
		String pwd = "auto123";

		LoginPage loginPage = new LoginPage(driver);
		loginPage.doLogin(user, pwd);
		//driver.quit();

	}
	
	@AfterMethod
	public void finishTests() {
		driver.quit();
		System.out.println("Finished Login Tests");
	}
	

}
