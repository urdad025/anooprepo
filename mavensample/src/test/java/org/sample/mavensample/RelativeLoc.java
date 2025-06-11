package org.sample.mavensample;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.openqa.selenium.support.locators.RelativeLocator.*;

public class RelativeLoc {

	public static void main(String[] args) {

		String url = "https://rahulshettyacademy.com/angularpractice/";
		WebDriver driver = new ChromeDriver();
		driver.get(url);

		WebElement nameEdit = driver.findElement(By.cssSelector("input.form-control.ng-invalid"));
		
		
		System.out.println(driver.findElement(with(By.tagName("label")).above(nameEdit)).getText());
		
		driver.findElement(with(By.tagName("input")).toLeftOf(By.cssSelector("label[for='exampleCheck1']"))).click();
		
		System.out.println(driver.findElement(with(By.tagName("label")).toRightOf(By.id("inlineRadio1"))).getText());
		
		
		
		
	WebElement dob = driver.findElement(By.cssSelector("label[for='dateofBirth']"));
		
		
		driver.findElement(with(By.tagName("input")).below(dob)).click();
		
		
		
		
		
	
	}

}
