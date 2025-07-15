package automationBlogSpot;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HandlingDatePicker1 {

	WebDriver driver;

	@BeforeClass
	public void setUp() {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().deleteAllCookies();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
	}

	@Test
	public void datePicker() {
		driver.findElement(By.xpath("//input[@id='datepicker']")).click();
		String date = "29";
		String month = "July";
		String year = "2004";

		selectYearMonth(driver, month, year);
		selectDate(driver, date);

	}

	public static void selectYearMonth(WebDriver driver, String month, String year) {
		while (true) {
			String currentMonth = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
			String currentYear = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();

			if (currentMonth.equals(month) && currentYear.equals(year)) {
				break;
			}
			driver.findElement(By.xpath("//a[@title='Prev']")).click();
		}
	}

	public static void selectDate(WebDriver driver, String date) {
		List<WebElement> allDates = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tr/td"));
		for (WebElement ad : allDates) {
			if (ad.getText().equals(date)) {
				ad.click();
			}
		}
	}

	@AfterClass
	public void teaDown() {
		driver.quit();
	}

}
