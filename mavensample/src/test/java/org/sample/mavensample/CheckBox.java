package org.sample.mavensample;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class CheckBox {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));	
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		Thread.sleep(2000L);
		
		
		WebElement checkff = driver.findElement(By.cssSelector("input[id*='friendsandfamily']"));
		
		Assert.assertFalse(checkff.isSelected());
		checkff.click();
		boolean b=checkff.isSelected();
		
		Assert.assertTrue(b);
		
		System.out.println(b);
		List<WebElement> checkboxs=driver.findElements(By.cssSelector("input[type='checkbox']"));
		
		for (WebElement a: checkboxs)
		{
		    String checkboxId = a.getDomAttribute("id");
			//Now go and print all the lables of checkboxes
		 //   System.out.println(checkboxId);
		    
            WebElement label = driver.findElement(By.cssSelector("label[for='" + checkboxId + "']"));
            System.out.println("Checkbox Label: " + label.getText() + "   -->> For id" + checkboxId);
		} 		
		
		
		driver.close();
	}
}
