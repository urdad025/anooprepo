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

public class StreamFilter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String item = "Banana";

		String url = "https://rahulshettyacademy.com/seleniumPractise/#/offers";
		WebDriver driver = new ChromeDriver();
		driver.get(url);

		driver.findElement(By.id("search-field")).sendKeys(item);

		// Read the table veg/fruit elements
		List<WebElement> elementList = driver
				.findElements(By.cssSelector("table[class='table table-bordered'] tbody tr td:nth-child(1)"));

		// Create a list with names
		List<WebElement> name = elementList.stream().filter(s -> s.getText().toLowerCase().contains(item.toLowerCase()))
				.collect(Collectors.toList());

		name.forEach(a -> System.out.println(a.getText()));

		Assert.assertTrue(name.stream().anyMatch(e -> e.getText().equalsIgnoreCase(item)));

		Assert.assertEquals(elementList.size(), name.size());

		driver.close();
	}

}
