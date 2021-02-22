package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InventarioPage extends BasePage {

	@FindBy(id = "cipl")
	WebElement ciplField;

	@FindBy(id = "stock")
	WebElement stockField;

	@FindBy(id = "stock2")
	WebElement stock2Field;

	@FindBy(id = "stock3")
	WebElement stock3Field;

	@FindBy(id = "stock4")
	WebElement stock4Field;

	@FindBy(name = "submit")
	WebElement btnBuscar;

	@FindBy(name = "SubmitButton")
	WebElement btnGuardar;

	@FindBy(xpath = "/html/body/div[3]/div[2]/div[5]/table/tbody/tr/td[14]/a[1]")
	WebElement btnEditar;

	@FindBy(xpath = "/html/body/div[3]/div[2]/div[5]/table/tbody/tr[1]/td[14]/a[2]/img")
	WebElement btnEliminar;

	@FindBy(xpath = "/html/body/div[3]/div[2]/div[2]/div[2]/div[4]/a")
	WebElement inventarioLink;

	WebDriver driver;

	public InventarioPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public void showInventarioByCod(String cipl) {
		clickOnElement(inventarioLink);
		switchToTab();
		waitUntilClickeable(ciplField, 10);

		typeOnElement(ciplField, cipl);
		clickOnElement(btnBuscar);
	}

	public void updateInventarioByCod(String[] stockData) {
		waitUntilClickeable(btnEditar, 10);

		clearOnElement(stockField);
		typeOnElement(stockField, stockData[0]);

		clearOnElement(stock2Field);
		typeOnElement(stock2Field, stockData[1]);

		clearOnElement(stock3Field);
		typeOnElement(stock3Field, stockData[2]);

		clearOnElement(stock4Field);
		typeOnElement(stock4Field, stockData[3]);

		clickOnElement(btnGuardar);
	}

	public void deleteInventarioByCod(String cipl) {
		waitUntilClickeable(btnEliminar, 10);

		acceptAlert();
		acceptAlert();
		acceptAlert();
	}
}
