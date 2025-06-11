package org.sample.mavensample;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutoSuggestDD {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));	
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
	
		driver.findElement(By.id("autosuggest")).sendKeys("IND");
		Thread.sleep(2000);
		
		List<WebElement> option = driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));
		Thread.sleep(2000);
		for( WebElement a: option)
			
		{
			if(a.getText().equalsIgnoreCase("INDIA"))
			{
				a.click();
				break;
			}
			
		}
		
		//driver.close();
	}

}
