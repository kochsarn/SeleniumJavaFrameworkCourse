package test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import config.PropertiesFile;
import demo.Log4jDemo;

public class TestNG_Demo {

	WebDriver driver = null;
	public static String browserName=null;
	// private static Logger Logger = LogManager.getLogger(Log4jDemo.class);
	@BeforeTest
	public void setUpTest() {

		String projectPath = System.getProperty("user.dir"); 
		PropertiesFile.getProperties();
		
		if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", projectPath+ "/drivers/chromedriver/chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if (browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", projectPath+"/drivers/geckodriver/geckodriver.exe");
			driver = new FirefoxDriver();
		}
		
			}

	@Test 
	public  void googleSearch21() {


		// goto google.com
		driver.get("https://google.com");
		driver.findElement(By.name("q")).sendKeys("Automation Step By Step");
		// Click on search button
		// driver.findElement(By.name("btnK")).click();
		driver.findElement(By.name("btnK")).sendKeys(Keys.RETURN);
		// close browser

	}
	
	@Test 
	public  void googleSearch12() {


		// goto google.com
		driver.get("https://google.com");
		driver.findElement(By.name("q")).sendKeys("Automation Step By Step");
		// Click on search button
		// driver.findElement(By.name("btnK")).click();
		driver.findElement(By.name("btnK")).sendKeys(Keys.RETURN);
		// close browser

	} 
	
	@AfterTest
	public void tearDownTest() {
		driver.close();
		driver.quit();
		System.out.println("Test Completed Successfully");
		PropertiesFile.setProperties();
	}

}