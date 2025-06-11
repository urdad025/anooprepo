package org.sample.mavensample;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class FluentWaitTest {

	public static void main(String[] args) {
		
		
		//WebDriverWait (for explicit wait) and FluentWait are selenium classed that impliment Wait interface. --  Most Important.
		//Where as for imlicit wait, it is managed by driver.manage().

		String url = "https://the-internet.herokuapp.com/dynamic_loading/1";
		WebDriver driver = new ChromeDriver();
		driver.get(url);

		driver.findElement(By.cssSelector("div[id='start'] button")).click();

		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(30))
				.pollingEvery(Duration.ofSeconds(3))
				.ignoring(NoSuchElementException.class);

		WebElement foo = wait.until(new Function<WebDriver, WebElement>() {

			public WebElement apply(WebDriver driver) {

				if (driver.findElement(By.cssSelector("div[id='finish'] h4")).isDisplayed()) {

					return driver.findElement(By.cssSelector("div[id='finish'] h4"));
				} else
					return null;

			}
		});

		System.out.println(foo.isDisplayed());
		System.out.println(foo.getText());
		driver.close();
	}
}
