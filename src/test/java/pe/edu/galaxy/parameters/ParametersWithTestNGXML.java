package pe.edu.galaxy.parameters;

import org.testng.annotations.AfterTest;
import org.testng.Assert;
import org.testng.AssertJUnit;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParametersWithTestNGXML {

	WebDriver driver = null;

	@BeforeTest
	public void setup() {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://google.com.pe");
	}

	@Test
	@Parameters({ "author", "searchKey" })
	public void test_google(@Optional("Optional Autor")String author, @Optional("Option searchKey")String searchKey){

		WebElement searchText = driver.findElement(By.name("q"));
		searchText.sendKeys(searchKey);
		
		System.out.println("Welcome ->" + author + " Your search key is->" + searchKey);
		System.out.println("Thread will sleep now");

		System.out.println("Value in Google Search Box = " + searchText.getAttribute("value") + " ::: Value given by input = " + searchKey);
		Assert.assertTrue(searchText.getAttribute("value").equalsIgnoreCase(searchKey));
	}

	@AfterTest
	public void tearDown() throws InterruptedException {
		Thread.sleep(3000);
		driver.close();
	}

}
