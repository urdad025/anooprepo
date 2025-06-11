package anooppandey.tests;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StandAloneTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/client");
		driver.manage().window().maximize();

		String prod1 = "ZARA COAT 3";

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		driver.findElement(By.id("userEmail")).sendKeys("jackreacher007@gmail.com");
		
	
		
		driver.findElement(By.id("userPassword")).sendKeys("Jack@1234");
		driver.findElement(By.id("login")).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));
		List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));

		// *******************************
		WebElement product1 = products.stream()
				.filter(product -> product.findElement(By.tagName("b")).getText().equals(prod1)).findFirst()
				.orElse(null);
		product1.findElement(By.cssSelector(".card-body button:last-of-type")).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
		// green message toast notification

		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".ng-animating")));
		// Progress animation

		// wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
		// Another way to use webelemernt istead of locator
		
		Thread.sleep(2000);

		driver.findElement(By.cssSelector("button[routerlink*='cart']")).click();

		List<WebElement> prodInCart = driver.findElements(By.cssSelector(".cartSection h3"));

		Boolean match = prodInCart.stream().anyMatch(pcart -> pcart.getText().equals(prod1));

		Assert.assertTrue(match);

		driver.findElement(By.cssSelector(".totalRow button")).click();

		/*
		 * driver.findElement(By.cssSelector(".form-group input")).sendKeys("Ind");
		 * 
		 * List<WebElement> country= driver.findElements(By.cssSelector(".ta-item"));
		 * 
		 * WebElement countryInd =
		 * country.stream().filter(a->a.findElement(By.tagName("span")).getText().equals
		 * ("India")).findFirst().orElse(null); countryInd.click();
		 */

		Actions a = new Actions(driver);

		a.sendKeys(driver.findElement(By.cssSelector(".form-group input")), "India").build().perform();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));

		driver.findElement(By.cssSelector(".ta-item:nth-of-type(2)")).click();
		driver.findElement(By.cssSelector(".action__submit")).click();
		String confirmMessage = driver.findElement(By.cssSelector(".hero-primary")).getText();
		Assert.assertTrue(confirmMessage.equalsIgnoreCase("Thankyou for the order."));

		driver.close();
	}

}
