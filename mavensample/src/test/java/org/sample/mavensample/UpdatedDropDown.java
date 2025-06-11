package org.sample.mavensample;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class UpdatedDropDown {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		//driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	
	
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		driver.findElement(By.id("divpaxinfo")).click();
		Thread.sleep(1000);
		
		int i=1;
		
		while (i<5)
		{
			driver.findElement(By.id("hrefIncAdt")).click();
			System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
			Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(), i+1+" Adult");
		i++;
		}
		driver.findElement(By.id("btnclosepaxoption")).click();
		
		
		//System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
		
		driver.close();
		
	}

}
