package org.sample.mavensample;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class FrameTest {

	public static void main(String[] args) throws InterruptedException {

		String url = "https://jqueryui.com/droppable/";
		WebDriver driver = new ChromeDriver();
		driver.get(url);

		
		//Switch to frame
		//driver.switchTo().frame(driver.findElement(By.cssSelector("iframe[class='demo-frame']")));
		driver.switchTo().frame(0);
		WebElement first = driver.findElement(By.cssSelector("div[id='draggable']"));
		WebElement second = driver.findElement(By.cssSelector("div[id='droppable']"));
		
		//Now Drag and drop
		Actions a = new Actions(driver);
		a.dragAndDrop(first, second).build().perform();
		
		driver.switchTo().defaultContent(); //To come back to HTML from iFrame

		
	

	}

}
