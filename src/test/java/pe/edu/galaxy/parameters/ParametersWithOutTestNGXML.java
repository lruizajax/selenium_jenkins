package pe.edu.galaxy.parameters;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ParametersWithOutTestNGXML {

	WebDriver driver = null;
	static String author = "Luis Ruiz";
	static String searchKey = "conoce.pe";

	@BeforeTest
	public void setup() {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@BeforeClass
	public void load() {
		driver.get("https://google.com.pe");
	}

	@Test
	public void google_search() {
		WebElement searchText = driver.findElement(By.name("q"));
		searchText.sendKeys(searchKey);

		System.out.println("Welcome -> " + author + " Your search key is -> " + searchKey);
		System.out.println("Thread will sleep now");

		System.out.println("Value in Google Search Box = " + searchText.getAttribute("value")
				+ " ::: Value given by input = " + searchKey);
		Assert.assertTrue(searchText.getAttribute("value").equalsIgnoreCase(searchKey));
	}

	@AfterTest
	public void tearDown() throws InterruptedException {
		Thread.sleep(3000);
		driver.close();
	}
}
