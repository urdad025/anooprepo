package org.sample.mavensample;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Locators {

	public static void main(String[] args) throws InterruptedException	{
		// TODO Auto-generated method stub
		
		String usname = "Ajay";
		String password="aabbccdd";
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://rahulshettyacademy.com/locatorspractice/#");
		
		driver.findElement(By.id("inputUsername")).sendKeys(usname);
		
		driver.findElement(By.name("inputPassword")).sendKeys(password);
		driver.findElement(By.className("signInBtn")).click();
		
	//********************************************	
		//Css Selector
		// 1 - Class name CSS selector --> tagname.classname --> Ex -> button.signInBtn (for submit button as class name provided there)
					//<button class="submit signInBtn" type="submit">Sign In</button>
		
		//2 - ID CSS selector --> tagname#id --> Ex --> input#inputUsername 
					//<input type="text" placeholder="Username" id="inputUsername" value="">
		//When ID and alss ios not procvided then??
		//3. Attribute CSS selector (generic sentax) --> tagname[attribute='value'] -- Ex--> input[@name='inputPassword']
				//<input type="password" placeholder="Password" name="inputPassword" value="">
		//Xpath - Double slash "//tagname[@attribute='value'] -> 
		//*****************************************
		
	String error = 	driver.findElement(By.cssSelector("p.error")).getText();
		
	System.out.println(error);
	

   driver.findElement(By.linkText("Forgot your password?")).click();
	
	System.out.println(driver.getCurrentUrl());
	
	
	Thread.sleep(1000);


	driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys(usname);
	driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys("ajay@gmail.com");
	driver.findElement(By.xpath("//input[@placeholder='Phone Number']")).sendKeys("1234567890");
	driver.findElement(By.cssSelector("button.reset-pwd-btn")).click();
	String pass = driver.findElement(By.xpath("//p[@class='infoMsg']")).getText();
	System.out.println(pass);
	
	String[] passfetch = pass.split("'");

	System.out.println(passfetch[1]);
	password=passfetch[1];
	driver.findElement(By.cssSelector("button.go-to-login-btn")).click();
	Thread.sleep(1000);
	
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
}
