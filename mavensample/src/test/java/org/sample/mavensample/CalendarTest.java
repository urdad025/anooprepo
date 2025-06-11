package org.sample.mavensample;


import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class CalendarTest {

	public static void main(String[] args) throws InterruptedException {

		String monthNum = "6";
		String date = "15";
		String year = "2027";

		String calMonth = null, calday = null, calyear = null;

		String url = "https://rahulshettyacademy.com/seleniumPractise/#/offers";
		WebDriver driver = new ChromeDriver();
		driver.get(url);
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

		driver.findElement(By.className("react-date-picker__inputGroup")).click();
		driver.findElement(By.cssSelector(".react-calendar__navigation__label")).click();
		driver.findElement(By.cssSelector(".react-calendar__navigation__label")).click();

		driver.findElement(By.xpath("//button[text()='" + year + "']")).click();

		driver.findElements(By.cssSelector(".react-calendar__year-view__months__month"))
				.get(Integer.parseInt(monthNum) - 1).click();

		driver.findElement(By.xpath("//abbr[text()='" + date + "']")).click();

		System.out.println(driver.findElement(By.className("react-date-picker__inputGroup"))
				.findElement(By.xpath(".//input")).getDomAttribute("value"));

		List<WebElement> dates = driver.findElements(By.cssSelector(".react-date-picker__inputGroup__input"));

		for (WebElement x : dates) {

			if (x.getDomAttribute("name").contains("month")) {
				calMonth = x.getDomAttribute("value");
				System.out.println(calMonth);
			} else if (x.getDomAttribute("name").contains("day")) {
				calday = x.getDomAttribute("value");
				System.out.println(calday);
			} else if (x.getDomAttribute("name").contains("year")) {
				calyear = x.getDomAttribute("value");
				System.out.println(calyear);
			} else {
				System.out.println("No date detauls found");
			}

		
		}
		//Assert.assertEquals(calMonth, monthNum);
		//Assert.assertEquals(calday, date);
		//Assert.assertEquals(calyear, year );
		Assert.assertTrue(
	            calMonth.equals(monthNum) && calday.equals(date) && calyear.equals(year), "Month, Day, or Year do not match expected values");

		
		driver.close();
	}
		
	}

