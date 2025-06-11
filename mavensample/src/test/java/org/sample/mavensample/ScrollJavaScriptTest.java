package org.sample.mavensample;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.Assert;

public class ScrollJavaScriptTest {

	public static void main(String[] args) throws InterruptedException {

		String url = "https://rahulshettyacademy.com/AutomationPractice/";
		WebDriver driver = new ChromeDriver();
		
	//	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(3));
				
		driver.get(url);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(4000L);
		js.executeScript("document.querySelector('.tableFixHead').scrollTop=1000");
		List<WebElement> amount = driver.findElements(By.xpath("//div[@class='tableFixHead']//tbody//tr//td[4]"));
		int sum = 0;
		for (WebElement x : amount) {
			sum = sum + Integer.parseInt(x.getText());
		}
		System.out.println(sum);
		String[] a = driver.findElement(By.cssSelector(".totalAmount")).getText().split(" ");
		Assert.assertEquals(sum, Integer.parseInt(a[a.length - 1].trim()));

		List<WebElement> table = driver.findElements(By.xpath("//table[@class='table-display']//tbody//tr"));
		System.out.println("Number of rows in Table: " + table.size());
		
		List<WebElement> row2 = table.get(2).findElements(By.xpath(".//td"));
		
		for (WebElement x: row2) {
			System.out.println(x.getText());
		}
		
		driver.findElement(By.cssSelector("input[id='autocomplete']")).sendKeys("Uni");
		Thread.sleep(3000l);
		
		List<WebElement> country=driver.findElements(By.cssSelector("li[class='ui-menu-item'] div"));
		
		String selectedCountry = null;
		for(WebElement con: country)
			
		{
			if(con.getText().equalsIgnoreCase("United ARAB Emirates"))
			{
				selectedCountry = con.getText();
				con.click();
				break;
			}
			
		}
		System.out.println("Selected country is: "+selectedCountry);
		
		

	}

}
