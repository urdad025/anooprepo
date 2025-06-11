package org.sample.mavensample;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicDropDown {


	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		//   //a[@value='MAA'] --- (//a[@value='MAA'])[2]
		//   //a[@value='BLR']
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	
	
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
	
	//	driver.findElement(By.xpath("//a[@value='BLR']")).click();
		//Thread.sleep(2000); 
		//driver.findElement(By.xpath("//a[@value='MAA']")).click();  // WILL GIVE ERROR.
		
	//	driver.findElement(By.xpath("(//a[@value='MAA'])[2]")).click();
		
		
		String originst= "//div[@id='glsctl00_mainContent_ddl_originStation1_CTNR'] //a[@value='BLR']";
		String Destinationst="//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']";
		
		//CAN WE DO IT WITHOUT PROVIDING INDEX.??
		
	// -->	//div[@id='glsctl00_mainContent_ddl_originStation1_CTNR'] //a[@value='BLR']
		
	// ->	//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']
		
		
		
		driver.findElement(By.xpath(originst)).click();
		Thread.sleep(1200); 
	    driver.findElement(By.xpath(Destinationst)).click();

	   System.out.println(driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).getDomProperty("value"));
	   System.out.println(driver.findElement(By.id("ctl00_mainContent_ddl_destinationStation1_CTXT")).getDomProperty("value"));
	    
		//
		
	}

}
