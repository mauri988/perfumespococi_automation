package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ProductoPage;

public class TestsProducto {
	public static String url = "http://localhost/perfumespococi/";
	String user = "paul";
	String pwd = "canastos123";

	private WebDriver driver;

	@BeforeMethod
	public void setUpDriver() {
		driver = new FirefoxDriver();
		driver.get(url);
	}

	@Test(priority = 0)
	public void addProductoTest() {
		String codigo = "05028";
		String nombre = "automation-prod";

		LoginPage loginPage = new LoginPage(driver);
		ProductoPage productoPage = new ProductoPage(driver);

		loginPage.doLogin(user, pwd);
		productoPage.createProducto(codigo, nombre);
		driver.quit();
	}

	@Test(priority = 1)
	public void updateProductoTest() {
		String codigo = "05028";

		String nombre = "automation-prod-updated";
		String newCodigo = "05028";
		String cipl = "05028";
		String descripcion = "Producto actualizado con selenium";
		String proveedor = "saint honore";
		String categoria = "Aguas";
		String medida = "Kilogramo";

		String[] data = { nombre, newCodigo, cipl, descripcion, proveedor, categoria, medida };

		LoginPage loginPage = new LoginPage(driver);
		ProductoPage productoPage = new ProductoPage(driver);

		loginPage.doLogin(user, pwd);
		productoPage.showProductoByCod(codigo);
		productoPage.updateProductoByCod(data);
		driver.quit();
	}

	@Test(priority = 2)
	public void deleteProductoTest() {
		String codigo = "05028";

		LoginPage loginPage = new LoginPage(driver);
		ProductoPage productoPage = new ProductoPage(driver);

		loginPage.doLogin(user, pwd);
		productoPage.showProductoByCod(codigo);
		productoPage.deleteProductoByCod(codigo);
		driver.quit();
	}

	@AfterTest
	public void finishTests() {
		System.out.println("Finished Producto Tests");
	}
}