package demoQA;

import java.time.Duration;
import java.util.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HandlingDatePicker {

	WebDriver driver;

	@BeforeClass
	public void setUp() {
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demoqa.com/date-picker");
		driver.manage().window().maximize();
	}

	@Test
	public void usingSendKeys() {
		WebElement datePicker = driver.findElement(By.xpath("//input[@id='datePickerMonthYearInput']"));
		datePicker.clear();
		datePicker.sendKeys("15/08/2050");
	}

	@Test
	public void usingCalander() {

		String reqMonth = "Agust";
		String reqYear = "2020";
		String reqDate = "15";
		// Click on datePicker
		driver.findElement(By.xpath("//input[@id='datePickerMonthYearInput']")).click();
		// Select Month and Year
		WebElement monthDrp = driver.findElement(By.xpath("//select[@class='react-datepicker__month-select']"));
		WebElement yearDrp = driver.findElement(By.xpath("//select[@class='react-datepicker__year-select']"));
		Select month = new Select(monthDrp);
		month.selectByVisibleText(reqMonth);
		Select year = new Select(yearDrp);
		year.selectByVisibleText(reqYear);
		// Select Date
		List<WebElement> allDates = driver.findElements(By.xpath("//div[@class='react-datepicker__month']//div"));
		for (WebElement ad : allDates) {
			if (ad.getText().equals(reqDate)) {
				ad.click();
				break;
			}
		}

	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
