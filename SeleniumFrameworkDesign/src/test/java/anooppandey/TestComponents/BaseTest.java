package anooppandey.TestComponents;

import org.testng.annotations.AfterMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.*;

import anooppandey.pageobjects.LandingPage;
import anooppandey.resources.ReadGDProperties;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	public WebDriver driver;
	public LandingPage landingPage;

	public WebDriver initializerDriver() throws IOException {

		/* --> Moved to new method ReadGDProperties.getProperties()
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "//src//main//java//anooppandey//resources//GlobalData.properties");
		prop.load(fis);
		*/
		
		Properties prop = ReadGDProperties.getProperties();
		
		// String browserName = prop.getProperty("browser"); --> Only when pick from
		// GlobalData.properties file under anooppandey.resources
		// When passing value from Terminal, use ternary operator, as mentioned below

		String browserName = System.getProperty("browser") != null ? System.getProperty("browser")
				: prop.getProperty("browser");

		if (browserName.contains("chrome")) {

			ChromeOptions option = new ChromeOptions(); // for headless execution means executio willbe done by chrome
														// engine without opening chrome on system.
			WebDriverManager.chromedriver().setup();

			if (browserName.contains("headless")) {
				option.addArguments("headless");
			}
			driver = new ChromeDriver(option); // passing ChromeOptions object in ChromeDriver
		} else if (browserName.equalsIgnoreCase("safari")) {

			driver = new SafariDriver();

		}

		if (browserName.contains("headless")) {
			driver.manage().window().setSize(new Dimension(1440, 900)); // set fixed size in headless
		} else {
			driver.manage().window().maximize(); // maximize window in normal mode
		}

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		return driver;
	}

	@BeforeMethod(alwaysRun = true)
	public LandingPage launchApplication() throws IOException {

		driver = initializerDriver();
		landingPage = new LandingPage(driver);
		landingPage.goTo();
		return landingPage;

	}

	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		driver.close();
	}

	public List<HashMap<String, String>> getJsonDataMap(String filePath) throws IOException {

		// read json to String
		// filePath = System.getProperty("user.dir")+"//src//main//java//anooppandey//data//PurchaseOrder.json"

		String jsonContent = FileUtils.readFileToString(new File(filePath), StandardCharsets.UTF_8);

		// String to HashMap - (Need new dependency - Jackson Databind
		ObjectMapper mapper = new ObjectMapper();

		List<HashMap<String, String>> data = mapper.readValue(jsonContent,
				new TypeReference<List<HashMap<String, String>>>() {
				});
		return data;
	}

	public String getScreenShot(String testCaseName, WebDriver driver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir") + "//reports//" + testCaseName + ".png";
		File destination = new File(path);
		FileUtils.copyFile(source, destination);
		return path;

	}

}
