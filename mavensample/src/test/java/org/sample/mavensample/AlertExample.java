package org.sample.mavensample;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertExample {

	public static void main(String[] args) throws InterruptedException {

		String textname = "Anoop";
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		System.out.println(driver.findElement(By.id("name")).getDomAttribute("placeholder"));
		driver.findElement(By.id("name")).sendKeys(textname);

		driver.findElement(By.cssSelector("input[id='alertbtn']")).click();
		Thread.sleep(1000L);

		// Managing Alert --> When only accept (Ok option only)
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();
		Thread.sleep(1000L);

		// Managing Alert --> When accept (Ok/Yes option) and dismiss (cancel/No
		// option)is available
		driver.findElement(By.id("name")).sendKeys(textname);
		driver.findElement(By.cssSelector("input[id='confirmbtn']")).click();
		Thread.sleep(1000L);
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();
		Thread.sleep(1000L);

		driver.findElement(By.id("name")).sendKeys(textname);
		driver.findElement(By.cssSelector("input[id='confirmbtn']")).click();
		Thread.sleep(1000L);
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().dismiss();
		Thread.sleep(1000L);

		//

		driver.close();

	}

}
