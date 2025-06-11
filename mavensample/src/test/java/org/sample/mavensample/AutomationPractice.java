package org.sample.mavensample;


import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class AutomationPractice {

	public static void main(String[] args) throws InterruptedException {

		String url = "https://rahulshettyacademy.com/AutomationPractice/";
		WebDriver driver = new ChromeDriver();
		driver.get(url);
		// Count of links on webpage
		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println("*****Total Link in the page: " + links.size());

		for (WebElement x : links) {
			System.out.println(x.getText() + "----" + x.getDomAttribute("href"));
		}
		// Count of links on footer of webpage
		WebElement base = driver.findElement(By.id("gf-BIG")); // Locator for footer section.
		List<WebElement> footerLinks = base.findElements(By.tagName("a")); // now Foorter webelement will work as driver
																			// to find locatores in it.

		System.out.println("*****Total Link in webpage footer: " + footerLinks.size());

		/*
		 * for (WebElement x : footerLinks) { System.out.println(x.getText() + "----" +
		 * x.getDomAttribute("href")); }
		 */
		// Find links per column in footer section.
		int itr = base.findElements(By.tagName("ul")).size();
		for (int i = 1; i <= itr; i++) {
			List<WebElement> linkPerCol = base.findElements(By.xpath("(//ul)[" + i + "]//li//a"));
			System.out
					.println("************ Total link in Column " + i + " is: " + linkPerCol.size() + "**************");

			for (WebElement x : linkPerCol) {
				System.out.println(x.getText() + "----" + x.getDomAttribute("href"));
			}
		}
		/*
		 * Click on all links of the columns to check if the pages are opening. for (int
		 * j = 1; j <= itr; j++) { List<WebElement> linkPerCol =
		 * base.findElements(By.xpath("(//ul)[" + j + "]//li//a"));
		 * 
		 * System.out.println(linkPerCol.get(0).getText()); }
		 */

		// Click on the links first columns to check if the pages are opening.
		System.out.println("*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*");

		List<WebElement> linkPerCol = base.findElements(By.xpath("(//ul)[1]//li//a"));

		for (int k = 1; k < linkPerCol.size(); k++) {
			System.out.println(linkPerCol.get(k).getText());

			String clickOnLink = Keys.chord(Keys.COMMAND, Keys.ENTER);
			linkPerCol.get(k).sendKeys(clickOnLink);
			Thread.sleep(2500L);
		}
		
	Set<String> allOpenWindows = 	driver.getWindowHandles();
	String mainwindow = driver.getWindowHandle();
	
	for (String linkedWindows :allOpenWindows ) {
		
		if(!linkedWindows.equals(mainwindow)){
			driver.switchTo().window(linkedWindows);
			
		System.out.println(driver.getTitle());
		
		}
	}

		driver.quit();

	}
}
