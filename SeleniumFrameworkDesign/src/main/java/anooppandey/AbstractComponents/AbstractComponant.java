package anooppandey.AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import anooppandey.pageobjects.MyCart;
import anooppandey.pageobjects.OrderHistory;

public class AbstractComponant {

	WebDriver driver;

	public AbstractComponant(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "button[routerlink*='cart']")
	private WebElement cartHeader;
	
	@FindBy(css = "button[routerlink*='myorders']")
	private WebElement orderHeader;

	public void waitForElementToAppear(By locator) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

	}
	
	public void waitForElementToAppear(WebElement webElement) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(webElement));

	}

	public void waitForElementToDisappear(WebElement webElement) throws InterruptedException {
		
		Thread.sleep(2000);
		
		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
		//wait.until(ExpectedConditions.invisibilityOf(webElement));

	}

	public MyCart goToCart() throws InterruptedException {

		Thread.sleep(1000);
		cartHeader.click();
		return new MyCart(driver);
		 
	}
	
	public OrderHistory goToOrderHistory()  {

		
		orderHeader.click();
		return new OrderHistory(driver);
	
	}

}
