package org.sample.mavensample;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MultipleDataSet {

	public static void main(String[] args) throws InterruptedException {

		String[] items = { "Nuts Mixture", "Brocolli", "Water Melon" };

		String url = "https://rahulshettyacademy.com/seleniumPractise/";

		WebDriver driver = new ChromeDriver();

		WebDriverWait expWait = new WebDriverWait(driver, Duration.ofSeconds(8)); // Explicitly wait

		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
		// //Implicitly wait
		driver.get(url);
		addItemstoCart(driver, items); // Select items and add to cart
		clickCheckOut(driver); // Click on Cart to verify items/ quantity and price
		proceedToCheckOut(driver); // Proceed wit check out
		promoCode(driver, expWait);
		driver.close();
	}

	public static void addItemstoCart(WebDriver driver, String[] items) {

		int itr = 0;

		List<WebElement> products = driver.findElements(By.cssSelector("h4[class='product-name']"));
		System.out.println("Number of ptoduct Name Labels: " + products.size());

		System.out.println("Number of ptoduct Name Labels: "
				+ driver.findElements(By.xpath("//button[text()='ADD TO CART']")).size());

		List<String> itemsList = Arrays.asList(items);
		for (int i = 0; i < products.size(); i++) {

			// Check if items extracted present in array - items or not)
			String itemName = products.get(i).getText();

			String vegName = itemName.split(" -")[0];
			if (itemsList.contains(vegName)) {
				itr++;
				// using sibling
				// products.get(i).findElement(By.xpath("following-sibling::div/button")).click();

				// or below can be used instead --> using the parent tag, traverse to child and
				// use index
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();

				System.out.println("Item Added: Item " + itr + ": " + vegName);
			}

			if (itr == items.length) {
				break;

			}

		}

	}

	public static void clickCheckOut(WebDriver driver) {

		driver.findElement(By.cssSelector("img[alt='Cart']")).click();

		verifyItemsinCart(driver);

	}

	public static void verifyItemsinCart(WebDriver driver) {

		List<WebElement> itemsInCart = driver
				.findElements(By.xpath("//div[@class='cart-preview active']//div//div[@class='product-info']"));
		System.out.println("Items added to cart are as below:");
		System.out.println("************************************");

		for (WebElement x : itemsInCart) {
			System.out.println("Item: " + x.findElement(By.xpath("p[@class='product-name']")).getText());
			System.out.println("Price: " + x.findElement(By.xpath("p[@class='product-price']")).getText());
			System.out.println("Quantity: "
					+ x.findElement(By.xpath("following-sibling::div[@class='product-total']//p[@class='quantity']"))
							.getText());
			System.out.println("Amount: "
					+ x.findElement(By.xpath("following-sibling::div[@class='product-total']//p[@class='amount']"))
							.getText());
			System.out.println("************************************");

		}

	}

	public static void proceedToCheckOut(WebDriver driver) {
		driver.findElement(By.cssSelector("div[class='cart-preview active'] button[type='button']")).click();
	}

	public static void promoCode(WebDriver driver, WebDriverWait expWait) throws InterruptedException {

		String promo = "rahulshettyacademy";
		expWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input.promoCode")));
		driver.findElement(By.cssSelector("input.promoCode")).sendKeys(promo);
		driver.findElement(By.cssSelector("button[class='promoBtn']")).click();
		System.out.println(driver.findElement(By.cssSelector("button[class='promoBtn']")).getText());
		expWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoInfo")));
		System.out.println(driver.findElement(By.cssSelector("span.promoInfo")).getText());

	}

}
