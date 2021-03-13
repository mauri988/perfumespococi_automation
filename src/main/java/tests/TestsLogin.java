package tests;

import org.testng.annotations.Test;

import pages.LoginPage;

public class TestsLogin extends BaseTest {

	@Test(priority = 0)
	public void testLogin() {
		String user = "paul";
		String pwd = "canastos123";

		LoginPage loginPage = new LoginPage(driver);
		loginPage.doLogin(user, pwd);
	}

	@Test(priority = 1)
	public void testIncorrectPassword() {
		String user = "paul";
		String pwd = "auto123";

		LoginPage loginPage = new LoginPage(driver);
		loginPage.doLogin(user, pwd);
	}

	@Test(priority = 2)
	public void testIncorrectUsername() {
		String user = "test";
		String pwd = "canastos123";

		LoginPage loginPage = new LoginPage(driver);
		loginPage.doLogin(user, pwd);
	}

	@Test(priority = 3)
	public void testIncorrectCredentials() {
		String user = "test";
		String pwd = "auto123";

		LoginPage loginPage = new LoginPage(driver);
		loginPage.doLogin(user, pwd);
	}

}
