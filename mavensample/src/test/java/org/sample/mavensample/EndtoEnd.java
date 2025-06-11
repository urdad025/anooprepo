package org.sample.mavensample;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class EndtoEnd {

	public static void main(String[] args) throws InterruptedException {
	
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

		// Country
		driver.findElement(By.id("autosuggest")).sendKeys("IND");
		Thread.sleep(2000);

		List<WebElement> option = driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));
		Thread.sleep(2000);
		for (WebElement a : option)

		{
			if (a.getText().equalsIgnoreCase("INDIA")) {
				a.click();
				break;
			}
		}

		// Radio Button

		String style = driver.findElement(By.id("Div1")).getDomAttribute("style");
		Assert.assertEquals(false, cal2enabled(style));

		// function calling for comparision style

		// System.out.println("Radio Button - Round Trip is selected");

		// driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();

		style = driver.findElement(By.id("Div1")).getDomAttribute("style");
		// Assert.assertEquals(true, cal2enabled(style));

		// Origin and Destination
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		String originst = "//div[@id='glsctl00_mainContent_ddl_originStation1_CTNR'] //a[@value='BLR']";
		String Destinationst = "//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']";
		driver.findElement(By.xpath(originst)).click();
		Thread.sleep(1200);
		driver.findElement(By.xpath(Destinationst)).click();
		System.out.println("Journy Details");
		System.out.println("From: "
				+ driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).getDomProperty("value"));
		System.out.println("To: "
				+ driver.findElement(By.id("ctl00_mainContent_ddl_destinationStation1_CTXT")).getDomProperty("value"));

		// Calendar
		driver.findElement(By.cssSelector(".ui-state-default.ui-state-active")).click();
		System.out.println(
				"Departure Date: " + driver.findElement(By.cssSelector("span[id='view_fulldate_id_1']")).getText());

		// Passengers
		driver.findElement(By.id("divpaxinfo")).click();
		Thread.sleep(1000);
		int i = 1;
		while (i < 5) {
			driver.findElement(By.id("hrefIncAdt")).click();

			i++;
		}

		driver.findElement(By.id("btnclosepaxoption")).click();

		System.out.println("Passenger: " + driver.findElement(By.id("divpaxinfo")).getText());
		Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(), "5 Adult");

		// Select dropdown with Select tag --> Currency

		WebElement staticDropdown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
		Select dropdown = new Select(staticDropdown);
		dropdown.selectByIndex(3);
		Thread.sleep(1000);
		dropdown.selectByVisibleText("AED");
		Thread.sleep(1000);
		dropdown.selectByValue("USD");
		System.out.println("Currency Selected:" + dropdown.getFirstSelectedOption().getText());

		// Checkbox
		String checkinput = "Family and Friends";
		List<WebElement> checkboxs = driver.findElements(By.cssSelector("input[type='checkbox']"));

		for (WebElement a : checkboxs) {
			String checkboxId = a.getDomAttribute("id");

			WebElement label = driver.findElement(By.cssSelector("label[for='" + checkboxId + "']"));

			if (label.getText().equals(checkinput)) {
				a.click();
				System.out.println("Is Checkbox selected? " + a.isSelected());
				System.out.println("Label of selected Checkbox: " + label.getText());
				break;
			}

		}

		// Click on search

		driver.findElement(By.id("ctl00_mainContent_btn_FindFlights")).click();

		Thread.sleep(2000L);
		driver.close();
	}

	public static boolean cal2enabled(String s) {
		if (s.contains("opacity: 1")) {
			System.out.println("Return Date Calendar is Enabled as style value is: " + s);
			return true;
		} else {
			System.out.println("Return Date Calendar is Disabled as style value is: " + s);
			return false;
		}

	}

}
