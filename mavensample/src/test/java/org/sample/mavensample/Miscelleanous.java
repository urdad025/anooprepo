package org.sample.mavensample;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Miscelleanous {

	public static void main(String[] args) throws IOException {

		String url = "https://rahulshettyacademy.com/dropdownsPractise/";
		WebDriver driver = new ChromeDriver();
		
		//driver.manage().window().maximize();
		//driver.manage().deleteAllCookies();
		driver.get(url);
		
		
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		FileUtils.copyFile(src,new File("/Users/dou6339/Desktop/SS/screenshot1.jpg"));
	}

}
