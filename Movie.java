package assign;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Movie {

	@Test
	public static void imdb() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\smita\\OneDrive\\Documents\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.imdb.com/");
		driver.manage().window().maximize();
		driver.findElement(By.id("suggestion-search")).sendKeys("Pushpa: The Rise - Part 1");
		driver.findElement(By.id("iconContext-magnify")).click();
		driver.findElement(By.linkText("Pushpa: The Rise - Part 1")).click();

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scroll(0,5725)");

		driver.findElement(By.xpath("(//a[@aria-label='See more'])[5]")).click();
		String ir = driver.findElement(By.xpath("(//td[@class='release-date-item__date']) [6]")).getText();
		System.out.println("IMDB Release Date : " + ir);
		String ic = driver.findElement(By.xpath("(//td[@class='release-date-item__country-name']) [6]")).getText();
		System.out.println("Country : " + ic);
		
		Assert.assertTrue(ir.equalsIgnoreCase("17 December 2021"));
		Assert.assertTrue(ic.equalsIgnoreCase("India"));


	}

	@Test
	public static void wiki() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\smita\\OneDrive\\Documents\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://en.wikipedia.org/");
		driver.manage().window().maximize();
		driver.findElement(By.id("searchInput")).sendKeys("Pushpa: The Rise - Part 1");
		driver.findElement(By.id("searchButton")).click();

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scroll(0,500)");

		String wr = driver.findElement(By.xpath("//tbody/tr[12]/td[1]/div[1]/ul[1]/li[1]")).getText();
		System.out.println("WIKI Release Date : " + wr);
		String wc = driver.findElement(By.xpath("(//td[@class='infobox-data'])[12]")).getText();
		System.out.println("Country : " + wc);
		
		Assert.assertTrue(wr.equalsIgnoreCase("17 December 2021"));
		Assert.assertTrue(wc.equalsIgnoreCase("India"));

	}

	

}
