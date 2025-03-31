package automateNow;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
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
		driver.get("https://practice-automation.com/calendars/");
		driver.manage().window().maximize();
	}

	@Test(description = "Handling Date Pickers")
	public void datePicker() {
		driver.findElement(By.xpath("//input[@id='g1065-2-1-selectorenteradate']")).click();

		String reqDate = "23";
		String reqMonth = "August";
		String reqYear = "2010";

		selectMonthYear(driver, reqMonth, reqYear);
		selectDate(driver, reqDate);

		driver.findElement(
				By.xpath("//div[@id='contact-form-1065-2-1']//button[@type='submit'][normalize-space()='Submit']"))
				.click();

	}

	public static void selectMonthYear(WebDriver driver, String month, String year) {
		while (true) {
			String currentMonth = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
			String currentYear = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();

			if (currentYear.equals(year) && currentMonth.equals(month)) {
				break;
			}
			driver.findElement(By.xpath("//a[@title='Prev']")).click();
		}
	}

	public static void selectDate(WebDriver driver, String date) {
		List<WebElement> allDates = driver.findElements(By.xpath("//td[@data-handler=\"selectDay\"]"));
		for (WebElement ad : allDates) {
			if (ad.getText().equals(date)) {
				ad.click();
			}
		}
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
