package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest{

	WebDriver driver;
	
	@BeforeMethod
	public void setUpDriver() {
		String url = "http://localhost/perfumespococi/";

		driver = new FirefoxDriver();
		//driver.manage().window().fullscreen();
		driver.get(url);
	}

	@AfterMethod
	public void finishTests() {
		driver.quit();
		System.out.println("Finished Login Tests");
	}
}
