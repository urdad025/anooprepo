package org.sample.mavensample;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class TableSorting {

	public static void main(String[] args) {

		String item = "Rice";

		String url = "https://rahulshettyacademy.com/seleniumPractise/#/";
		WebDriver driver = new ChromeDriver();
		driver.get(url);

		driver.findElement(By.cssSelector(".cart-header-navlink[href='#/offers']")).click();

		Set<String> windows = driver.getWindowHandles();
		Iterator<String> itr = windows.iterator();
		String parent = itr.next();
		String clild = itr.next();
		driver.switchTo().window(clild);

		// Click to chort the table
		driver.findElement(By.cssSelector("table[class='table table-bordered'] thead tr th:nth-child(1)")).click();

		// Read the table veg/fruit elements
		List<WebElement> elementList = driver
				.findElements(By.cssSelector("table[class='table table-bordered'] tbody tr td:nth-child(1)"));

		// Create a list with names
		List<String> name = elementList.stream().map(s -> s.getText()).collect(Collectors.toList());

		// Now short it and get a new list created to store that
		List<String> sortedNames = name.stream().sorted().collect(Collectors.toList());

		Assert.assertTrue(name.equals(sortedNames), "Not matching");
		List<String> price;

		do {

			List<WebElement> elementListfull = driver
					.findElements(By.cssSelector("table[class='table table-bordered'] tbody tr td:nth-child(1)"));
			price = elementListfull.stream().filter(s -> s.getText().contains(item)).map(s -> getPriceVeggie(s))
					.collect(Collectors.toList());

			price.forEach(a -> System.out.println(a));

			if (price.size() < 1) {
				driver.findElement(By.cssSelector("a[role='button'][aria-label='Next']")).click();
			}
		} while (price.size() < 1);

		// driver.quit();
	}

	private static String getPriceVeggie(WebElement s) {
		// TODO Auto-generated method stub

		return s.findElement(By.xpath(".//following-sibling::td[1]")).getText();
	}
}
