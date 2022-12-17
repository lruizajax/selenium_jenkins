package pe.edu.galaxy;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.annotations.AfterTest;

public class MultiBrowser {

	WebDriver driver = null;

	@Parameters("BrowserName")
	@BeforeTest
	public void setup(String BrowserName) {
		
		System.out.println("This test is running with browser: " + BrowserName);

		System.out.println("Thread Id: " + Thread.currentThread().getId());
		
		if (BrowserName.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (BrowserName.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} 
	}

	@Test
	public void google() throws InterruptedException {
		driver.get("https://www.google.com.pe/");
		driver.manage().window().maximize();
		Thread.sleep(3000);

	}

	@AfterTest
	public void teardown() {
		driver.quit();
	}

}
