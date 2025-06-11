package org.sample.mavensample;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class PracticeExercise {

	public static void main(String[] args) {
		String url = "https://rahulshettyacademy.com/AutomationPractice/";
		WebDriver driver = new ChromeDriver();
		driver.get(url);
		String option = "Option2"; // Fist time user input to checkbox. Not hardcoded for Select dropDown and
									// textbox. - Refer code below
		String selectedCheckbox = null;

		WebElement staticDropdown = driver.findElement(By.id("dropdown-class-example"));
		Select dropDown = new Select(staticDropdown);

		WebElement check = driver.findElement(By.id("checkbox-example"));
		List<WebElement> labels = check.findElements(By.tagName("label"));
		System.out.println(labels.size());
		for (WebElement x : labels) {
			System.out.println(x.getText());

			if (x.getText().trim().equals(option)) { // Checking if user input for checkbox is opresent in checck box
														// list

				x.findElement(By.xpath(".//input[@type='checkbox']")).click();
				selectedCheckbox = x.getText().trim(); // fetching the checkbox selected label and assigned it to new
														// varialbe.
				break;
			}
		}
		if (selectedCheckbox != null) { // checkpit to make sure check boc is selected
			dropDown.selectByVisibleText(selectedCheckbox);
		} else {
			System.out.println("No checkbox label matched the option: " + option);
		}

		driver.findElement(By.cssSelector("input[name='enter-name']"))
				.sendKeys(dropDown.getFirstSelectedOption().getText()); // Read selected dropdown value and put in text
																		// box

		driver.findElement(By.id("alertbtn")).click();
		String[] alert = driver.switchTo().alert().getText().replace(",", "").split(" ");

		Assert.assertTrue(Arrays.asList(alert).contains(selectedCheckbox)); // Used assert to verify alert message
																			// contains the user input.
		driver.switchTo().alert().accept();// Accepteed the alert pop-up

	}
}
