package org.sample.mavensample;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsDemo {

	public static void main(String[] args) {

		String url = "https://www.amazon.com/";
		WebDriver driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		WebElement accList = driver.findElement(By.cssSelector("div[id='nav-link-accountList']"));

		Actions actions = new Actions(driver);
		actions.moveToElement(accList).build().perform();

		WebElement txtBox = driver.findElement(By.cssSelector("input[id='twotabsearchtextbox']"));

		actions.moveToElement(txtBox).click().keyDown(Keys.SHIFT).sendKeys("hello").doubleClick().build().perform();

		actions.moveToElement(accList).contextClick().build().perform();

		driver.close();
		
	}

}
