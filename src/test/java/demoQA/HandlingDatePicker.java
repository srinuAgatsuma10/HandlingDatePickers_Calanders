package demoQA;

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
		driver.get("https://demoqa.com/date-picker");
		driver.manage().window().maximize();
	}

	@Test
	public void usingSendKeys() {

	}

	@Test
	public void usingCalander() {

	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
