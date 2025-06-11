package org.sample.mavensample;

import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class WindowHandels {

	public static void main(String[] args) {

		String email;
		String url = "https://rahulshettyacademy.com/loginpagePractise/#";
		WebDriver driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.findElement(By.className("blinkingText")).click();

		Set<String> windows = driver.getWindowHandles();
		Iterator<String> itr = windows.iterator();
		String parentId = itr.next();
		String childId = itr.next();
		driver.switchTo().window(childId);

		email = driver.findElement(By.cssSelector(".im-para.red")).getText().split(" ")[4].trim();
		System.out.println(email);

		driver.switchTo().window(parentId);

		driver.findElement(By.id("username")).sendKeys(email);
		driver.findElement(By.id("password")).sendKeys(email);

	}

}
