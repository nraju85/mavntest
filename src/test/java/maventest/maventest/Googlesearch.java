package maventest.maventest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Googlesearch {
	String baseURL = "https://www.google.com/";
	public WebDriver driver;

	@BeforeTest
	public void setBaseURL() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(baseURL);
		driver.manage().window().maximize();

	}

	@Test
	public void TEST_01() {

		WebElement p = driver.findElement(By.name("q"));
		p.sendKeys("Selenium");
		p.submit();
	}

	@Test
	public void TEST_02() {

		String title = driver.getTitle();
		System.out.println(title);
	}

	@AfterTest
	public void closeTest() throws InterruptedException {
		Thread.sleep(6000);
		driver.close();
	}

}
