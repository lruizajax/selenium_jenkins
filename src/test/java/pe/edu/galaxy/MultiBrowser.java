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
	static String path = "";
	WebDriver driver = null;

	@Parameters("BrowserName")
	@BeforeTest
	public void setup(String BrowserName) {
		
		System.out.println("This test is running with browser: " + BrowserName);

		System.out.println("Thread Id: " + Thread.currentThread().getId());
		
		if (BrowserName.equalsIgnoreCase("chrome")) {
			path = System.getProperty("user.dir");
	  		System.setProperty("webdriver.chrome.driver", "C:\Users\User\eclipse-workspace\automation\src\test\resources\browser\chromedriver.exe");
	 		driver.set(new ChromeDriver());
			//driver = new ChromeDriver();
		} else if (BrowserName.equalsIgnoreCase("firefox")) {
			path = System.getProperty("user.dir");
	  		System.setProperty("webdriver.chrome.driver", "C:\Users\User\eclipse-workspace\automation\src\test\resources\browser\geckodriver.exe");
	 		driver.set(new FirefoxDriver());
			//driver = new FirefoxDriver();
		} else if (BrowserName.equalsIgnoreCase("ie")) {
			path = System.getProperty("user.dir");
	  		System.setProperty("webdriver.chrome.driver", "C:\Users\User\eclipse-workspace\automation\src\test\resources\browser\msedgedriver.exe");
	 		driver.set(new InternetExplorerDriver());
			//driver = new InternetExplorerDriver();
		} else if (BrowserName.equalsIgnoreCase("opera")) {
			path = System.getProperty("user.dir");
	  		System.setProperty("webdriver.chrome.driver", "C:\Users\User\eclipse-workspace\automation\src\test\resources\browser\operadriver.exe");
	 		driver.set(new OperaDriver());
			//driver = new OperaDriver();
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
