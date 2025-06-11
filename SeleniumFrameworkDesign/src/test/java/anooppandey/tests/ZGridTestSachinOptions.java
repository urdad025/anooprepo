package anooppandey.tests;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.testng.annotations.Test;


public class ZGridTestSachinOptions {
    
	@Test
	public void homePageClick() throws MalformedURLException, URISyntaxException, InterruptedException {
		


        SafariOptions options = new SafariOptions();
        options.setCapability("platformName", "macOS"); // Optional but good for grid clarity

        WebDriver driver = new RemoteWebDriver(new URI("http://192.168.88.204:4444").toURL(), options);

        driver.get("http://google.com");
        System.out.println(driver.getTitle());

        driver.findElement(By.name("q")).sendKeys("Sachin Tendulkar");
        Thread.sleep(5000);

        driver.quit();
	
}
}

	

		

