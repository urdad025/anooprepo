package test;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;


public class GoogleVirat {
    
	@Test
	public void homePageClick() throws MalformedURLException, URISyntaxException, InterruptedException {
		

	DesiredCapabilities caps = new DesiredCapabilities();
	caps.setBrowserName("chrome");
	
	
	
	WebDriver driver = new RemoteWebDriver(new URI("http://192.168.88.204:4444").toURL(),caps);
	driver.get("http://google.com");
	
	System.out.println(driver.getTitle());
	
	driver.findElement(By.name("q")).sendKeys("Sachin Tendulkar");
	Thread.sleep(5000);
	
	
	driver.close();
	
}
}

	

		

