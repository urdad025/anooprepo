package anooppandey.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import anooppandey.AbstractComponents.AbstractComponant;

public class ProductCatalouge extends AbstractComponant {

	WebDriver driver;

	public ProductCatalouge(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	// List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));

	@FindBy(css = ".mb-3")
	private List<WebElement> products;
	
	@FindBy(css = ".ng-animating")
	private WebElement spinner;


	private By productBy = By.cssSelector(".mb-3");
	private By addToCart = By.cssSelector(".card-body button:last-of-type");
	private By toastMessage = By.cssSelector("#toast-container");

	public List<WebElement> getProductList() {

		waitForElementToAppear(productBy);

		return products;
	}

	public WebElement getProductByName(String productName) {

		WebElement prod = getProductList().stream()
				.filter(product -> product.findElement(By.tagName("b")).getText().equals(productName)).findFirst()
				.orElse(null);
		return prod;

	}

	public void addProductToCart(String productName) throws InterruptedException {

		WebElement prod = getProductByName(productName);
		prod.findElement(addToCart).click();
		waitForElementToAppear(toastMessage);
		waitForElementToDisappear(spinner);
		
		

	}


}
