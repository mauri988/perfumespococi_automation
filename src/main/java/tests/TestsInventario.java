package tests;

import org.testng.annotations.Test;

import pages.InventarioPage;
import pages.LoginPage;
import pages.ProductoPage;

public class TestsInventario extends BaseTest {

	String user = "paul";
	String pwd = "canastos123";

	@Test(priority = 0)
	public void createInventarioByCod() {
		String codigo = "05028";
		String nombre = "automation-prod";

		LoginPage loginPage = new LoginPage(driver);
		ProductoPage productoPage = new ProductoPage(driver);

		loginPage.doLogin(user, pwd);
		productoPage.createProducto(codigo, nombre);
	}

	@Test(priority = 1)
	public void updateInventarioByCod() {
		String cipl = "05028";
		String stock = "25";
		String stock2 = "40";
		String stock3 = "62";
		String stock4 = "15";
		String[] stockData = { stock, stock2, stock3, stock4 };

		LoginPage loginPage = new LoginPage(driver);
		InventarioPage inventarioPage = new InventarioPage(driver);

		loginPage.doLogin(user, pwd);
		inventarioPage.showInventarioByCod(cipl);
		inventarioPage.updateInventarioByCod(stockData);
	}

	@Test(priority = 2)
	public void deleteInventarioByCodigo() {
		String cipl = "05028";

		LoginPage loginPage = new LoginPage(driver);
		InventarioPage inventarioPage = new InventarioPage(driver);

		loginPage.doLogin(user, pwd);
		inventarioPage.showInventarioByCod(cipl);
		inventarioPage.deleteInventarioByCod(cipl);
	}

}
