package automationBlogSpot;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DatePicker_DateRange {
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
	public void datePickerRange() {
		// Date Picker One
		driver.findElement(By.xpath("//input[@id='start-date']"));
		
		String d1Month = "Dec";
		String d1Year = "2004";
		String d1Date = "12";
		
		// Need To Implement
	}

	@AfterClass
	public void teaDown() {
		driver.quit();
	}
}
