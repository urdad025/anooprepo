package anooppandey.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import anooppandey.AbstractComponents.AbstractComponant;

public class OrderHistory extends AbstractComponant {

	WebDriver driver;

	public OrderHistory(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(css = ".table-bordered tbody tr td:nth-of-type(2)")
	private List<WebElement> yourOrderHis;
	

	public Boolean verifyPlacedorder(String productName) {

		Boolean match = yourOrderHis.stream().anyMatch(pcart -> pcart.getText().equals(productName));
		return match;

	}

}
