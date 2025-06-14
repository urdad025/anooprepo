package anooppandey.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import anooppandey.AbstractComponents.AbstractComponant;

public class CheckOutPage extends AbstractComponant {

	WebDriver driver;

	public CheckOutPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = ".form-group input")
	private WebElement country;

	@FindBy(css = ".action__submit")
	private WebElement placeOrder;

	@FindBy(css = ".ta-item:nth-of-type(2)")
	private WebElement selectCountry;

	private By resultBy = By.cssSelector(".ta-results");

	public void selectCountry(String countryName) {

		Actions a = new Actions(driver);
		a.sendKeys(country, countryName).build().perform();

		waitForElementToAppear(resultBy);
		selectCountry.click();

	}
	
	
	public ConfirmationPage submitOrder() {
		placeOrder.click();
		
		return new ConfirmationPage(driver);
		
	}

}
