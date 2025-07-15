package automationBlogSpot;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HandlingDatePicker2 {
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
		driver.findElement(By.xpath("//input[@id='txtDate']")).click();

		String date = "29";
		String month = "July";
		String year = "2015";

		WebElement monthDrpDown = driver.findElement(By.xpath("//select[@class='ui-datepicker-month']"));
		WebElement yearDrpDown = driver.findElement(By.xpath("//select[@aclass='ui-datepicker-year']"));

		Select sl1 = new Select(monthDrpDown);
		sl1.selectByContainsVisibleText(month);
		Select sl2 = new Select(yearDrpDown);
		sl2.selectByContainsVisibleText(year);

		selectDate(driver, date);

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
