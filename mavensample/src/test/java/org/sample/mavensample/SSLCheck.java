package org.sample.mavensample;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SSLCheck {

	public static void main(String[] args) {
		
		ChromeOptions options = new ChromeOptions();
		
		options.setAcceptInsecureCerts(true);
		
		String url = "https://expired.badssl.com/";
		WebDriver driver = new ChromeDriver(options);
		driver.get(url);
		System.out.println(driver.getTitle());
		
	}

}
