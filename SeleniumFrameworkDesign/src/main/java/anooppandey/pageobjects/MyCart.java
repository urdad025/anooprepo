package anooppandey.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import anooppandey.AbstractComponents.AbstractComponant;

public class MyCart extends AbstractComponant {

	WebDriver driver;

	public MyCart(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(css = ".cartSection h3")
	private List<WebElement> itemsInCart;

	@FindBy(css = ".totalRow button")
	private WebElement checkoutBtn;



	public Boolean prodMatchIncart(String productName) {

		Boolean match = itemsInCart.stream().anyMatch(pcart -> pcart.getText().equals(productName));
		return match;
		
	}

	public CheckOutPage goToCheckout() {
		checkoutBtn.click();
		return new CheckOutPage(driver);
		 
	
	}
}
