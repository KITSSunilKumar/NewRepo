package webdriverTest2.webdriverTest2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AppTest {

	public static WebDriver driver;

	String webUrl = "http://www.demo.guru99.com/v4/";

	@BeforeTest

	public void launchBankingPage() {

		System.setProperty("webdriver.chrome.driver", "D://Selenium/CromeDriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(webUrl);

	}

	@Test(priority = 0)
	public void titleVerification() {
		String title = driver.getTitle();
		Assert.assertEquals("Guru99 Bank Home Page", title);
	}

	@Test(priority = 1)
	public void login() {

		driver.findElement(By.xpath("//input[@name='uid']")).sendKeys("mngr189480");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("asuhAdY");
		driver.findElement(By.xpath("//input[@name='btnLogin']")).click();

		String HomePageName = driver.findElement(By.xpath("//h2[@class='barone']")).getText();

		Assert.assertEquals("Guru99 Bank", HomePageName);

	}

	@AfterTest

	public void closeUrl() {
		driver.close();
	}

}
