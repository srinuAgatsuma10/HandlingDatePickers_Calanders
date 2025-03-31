package automateNow;

import java.time.Duration;

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
		
		while(true) {
			String currentMonth = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
			String currentYear = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
			if(currentYear.equals(currentYear) && currentMonth.endsWith(currentMonth)) {
				
			}
		}
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
