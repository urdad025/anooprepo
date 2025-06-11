package anooppandey.pageobjects;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import anooppandey.AbstractComponents.AbstractComponant;
import anooppandey.resources.ReadGDProperties;

public class LandingPage extends AbstractComponant {

	WebDriver driver;

	public LandingPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	// WebElement userEmail = driver.findElement(By.id("userEmail"));
	// page factory

	@FindBy(id = "userEmail")
	private WebElement userEmail;

	@FindBy(id = "userPassword")
	private WebElement userPassword;

	@FindBy(id = "login")
	private WebElement submit;
	
	@FindBy(css = "[class*='flyInOut']")
	private WebElement errorMessage;	

	public ProductCatalouge loginApplication(String email, String pwd) {
		userEmail.sendKeys(email);
		userPassword.sendKeys(pwd);
		submit.click();
		ProductCatalouge productCatalouge = new ProductCatalouge(driver);
		return productCatalouge;	
	}

	public void goTo() throws IOException {
		
		String url = ReadGDProperties.getProperties().getProperty("url");

		driver.get(url);

	}
	public String getErrorMessage() {
		
		waitForElementToAppear(errorMessage);
		
		return errorMessage.getText();
	}
}
