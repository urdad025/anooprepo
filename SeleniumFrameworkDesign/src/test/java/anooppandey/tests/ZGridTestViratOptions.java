package anooppandey.tests;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;


public class ZGridTestViratOptions {
    
	@Test
		    public void homePageClick() throws MalformedURLException, URISyntaxException, InterruptedException {

		        // Set up Chrome options instead of DesiredCapabilities
		        ChromeOptions options = new ChromeOptions();
		        options.setBrowserVersion("stable"); // Optional: specify browser version
		        options.setCapability("platformName", "MAC"); // Optional

		        // Connect to Selenium Grid
		        WebDriver driver = new RemoteWebDriver(new URI("http://192.168.88.204:4444").toURL(), options);

		        driver.get("http://google.com");
		        System.out.println(driver.getTitle());

		        driver.findElement(By.name("q")).sendKeys("Virat Kohli");
		        Thread.sleep(5000);

		        driver.quit();
	
}
}

	

		

