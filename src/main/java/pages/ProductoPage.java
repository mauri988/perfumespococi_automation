package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductoPage extends BasePage {

	@FindBy(xpath = "/html/body/div[3]/div[2]/div[2]/div[2]/div[3]/a")
	WebElement productoLink;

	@FindBy(xpath = "/html/body/div[3]/div[2]/div[5]/table[1]/tbody/tr/td/a")
	WebElement btnAgregar;

	@FindBy(xpath = "/html/body/div[3]/div[2]/div[5]/table[2]/tbody/tr/td[6]/a[1]")
	WebElement btnEditar;

	@FindBy(xpath = "/html/body/div[3]/div[2]/div[5]/table[2]/tbody/tr/td[6]/a[2]")
	WebElement btnEliminar;

	@FindBy(id = "search")
	WebElement searchField;

	@FindBy(id = "codproducto")
	WebElement codigoField;

	@FindBy(id = "cipl")
	WebElement ciplField;

	@FindBy(id = "descripcion")
	WebElement descripcionField;

	@FindBy(id = "nombre")
	WebElement nombreField;

	@FindBy(id = "proveedorid")
	WebElement proveedorField;
	
	@FindBy(id = "categoriaid")
	WebElement categoriaField;
	
	@FindBy(id = "medida")
	WebElement medidaField;
	
	@FindBy(name = "submit")
	WebElement btnBuscar;

	@FindBy(name = "SubmitButton")
	WebElement btnGuardar;
	
	WebDriver driver;

	public ProductoPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public void createProducto(String codigo, String nombre) {
		clickOnElement(productoLink);
		clickOnElement(btnAgregar);
		clickOnElement(codigoField);
		
		typeOnElement(codigoField, codigo);
		typeOnElement(nombreField, nombre);
		
		clickOnElement(btnGuardar);
	}

	public void showProductoByCod(String cipl) {
		clickOnElement(productoLink);
		clickOnElement(searchField);
		typeOnElement(searchField, cipl);
		clickOnElement(btnBuscar);
	}

	public void updateProductoByCod(String[] data) {
		clickOnElement(btnEditar);

		typeOnElement(nombreField, data[0]);
		typeOnElement(codigoField, data[1]);
		typeOnElement(ciplField, data[2]);
		typeOnElement(descripcionField, data[3]);

		onSelectableElement(proveedorField, data[4], 10);
		onSelectableElement(categoriaField, data[5], 10);
		onSelectableElement(medidaField, data[6], 10);

		clickOnElement(btnGuardar);
	}

	public void deleteProductoByCod(String cipl) {
		clickOnElement(btnEliminar);

		acceptAlert();
		acceptAlert();
		acceptAlert();
	}
}
