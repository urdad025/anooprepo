package org.sample.mavensample;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Locator2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		

		WebDriver driver = new ChromeDriver();
		
		
		String usname = "Ajay";
		
		String password=getPwd(driver);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		Thread.sleep(2000);
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		
			
		driver.findElement(By.cssSelector("input#inputUsername")).sendKeys(usname);	
		driver.findElement(By.name("inputPassword")).sendKeys(password);
		driver.findElement(By.cssSelector("input#chkboxOne")).click();
		driver.findElement(By.xpath("//input[@name='chkboxTwo']")).click();
		driver.findElement(By.className("signInBtn")).click();
		Thread.sleep(2000);
		String text =driver.findElement(By.tagName("p")).getText();
		System.out.println(text);
		Assert.assertEquals(text, "You are successfully logged in.");
		String textname =driver.findElement(By.cssSelector("div[class='login-container'] h2")).getText();
		System.out.println(textname);
		Assert.assertEquals(textname, "Hello "+usname+",");
		
		driver.findElement(By.cssSelector("button.logout-btn")).click();
		Thread.sleep(2000);
		String signin = driver.findElement(By.cssSelector("form[class='form'] h1")).getText();
		
		Assert.assertEquals(signin, "Sign in");

		driver.close();

	}
	
	public static String getPwd(WebDriver driver) throws InterruptedException {
		
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		 driver.findElement(By.linkText("Forgot your password?")).click();
			Thread.sleep(1000);
		 
		 driver.findElement(By.cssSelector("button.reset-pwd-btn")).click();
			String passText = driver.findElement(By.xpath("//p[@class='infoMsg']")).getText();
			System.out.println(passText);
			
			String[] passfetch = passText.split("'");

			System.out.println(passfetch[1]);
			String pwd=passfetch[1];
			return pwd;
}
}
