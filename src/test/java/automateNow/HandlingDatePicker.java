package automateNow;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
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
		
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
