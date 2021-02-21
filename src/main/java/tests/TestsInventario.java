package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.InventarioPage;
import pages.LoginPage;

public class TestsInventario {
	String url = "http://localhost/perfumespococi/";
	WebDriver driver;

	@BeforeMethod
	public void setUpDriver() {
		driver = new FirefoxDriver();
		driver.get(url);
	}

	@Test
	public void updateInventarioByCod() throws InterruptedException {
		String cipl1 = "05028";
		String cipl2 = "05030";
		String user = "paul";
		String pwd = "canastos123";
		String[] stockData = {"25", "40", "62", "15"};
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.doLogin(user, pwd);

		InventarioPage inventarioPage = new InventarioPage(driver);
		
		inventarioPage.deleteInventarioByCod(cipl1);
		inventarioPage.updateInventarioByCod(cipl2,stockData);
	}
}
