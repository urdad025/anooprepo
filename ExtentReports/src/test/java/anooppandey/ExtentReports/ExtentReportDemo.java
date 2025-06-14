package anooppandey.ExtentReports;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExtentReportDemo {

	ExtentReports extent;
	

	@BeforeTest
	public void config() {

		// Helpfil classes
		// 1 - ExtentReports
		// 2 - ExtentSparkReporter

		String path = System.getProperty("user.dir") + "//reports//index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Web Automation Report");
		reporter.config().setDocumentTitle("Test Results");

		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Jack Reacher");
		
		

	}

	@Test
	public void initialDemo() {

		ExtentTest test = extent.createTest("Script number 1");

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com");
		driver.manage().window().maximize();
		System.out.println(driver.getTitle());
		driver.close();
		
		test.fail("Result do not Match");
		extent.flush();
	}

}
