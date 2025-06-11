package org.sample.mavensample;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class NewWindow {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		String url = "https://rahulshettyacademy.com/angularpractice/";
		WebDriver driver = new ChromeDriver();
		driver.get(url);

		driver.switchTo().newWindow(WindowType.WINDOW);

		Set<String> windows = driver.getWindowHandles();

		/*
		 * Iterator<String> itr = windows.iterator(); String parent = itr.next(); String
		 * child = itr.next();
		 * 
		 * driver.switchTo().window(child);
		 */

		// Or below can be used .. this will remove 2 lines of code

		List<String> windowList = new ArrayList<>(driver.getWindowHandles());
		driver.switchTo().window(windowList.get(1));

		// now use index 1 for child and 0 for parent.

		driver.get("https://rahulshettyacademy.com/");

		String name = driver.findElement(By.cssSelector("div[id='courses-block'] div:first-of-type h2 a")).getText();
		driver.switchTo().window(windowList.get(0));

		WebElement nameTxt = driver.findElement(By.cssSelector("input.form-control.ng-invalid"));
		nameTxt.sendKeys(name);
		
		File file = nameTxt.getScreenshotAs(OutputType.FILE);

		//Screenshots
		FileUtils.copyFile(file, new File("SS/21.jpg"));
		//FileUtils.copyFile(src,new File("/Users/dou6339/Desktop/SS/screenshot.jpg"));
		
		//get Height & Width
		System.out.println(nameTxt.getRect().getDimension().getHeight());
		System.out.println(nameTxt.getRect().getDimension().getWidth());
		

		driver.quit();

	}

}
