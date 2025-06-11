package org.sample.mavensample;

//import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserActivites {

	public static void main(String[] args) throws InterruptedException  {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
	//	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
	
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		
		driver.navigate().to("https://google.com");
		
		driver.navigate().back();
		
		Thread.sleep(2000);
		System.out.println(driver.getCurrentUrl());
		
		driver.navigate().forward();
		Thread.sleep(2000);
		driver.close();

	}

}
