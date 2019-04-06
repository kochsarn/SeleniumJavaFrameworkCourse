package demo;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class SauceLabsDemo {
	public static final String USERNAME = "watchara";
	public static final String ACCESS_KEY = "586bd392-c07a-4f84-8499-cca6e7150b66"; // It is not your password!
	public static final String URL = "http://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:80/wd/hub";

	public static void main(String[] args) throws MalformedURLException {
		DesiredCapabilities caps = DesiredCapabilities.chrome();
		caps.setCapability("platform", "Windows 10");
		caps.setCapability("version", "latest");

		String projectPath = System.getProperty("user.dir");
		System.out.println("projectpath :"+projectPath);


		System.setProperty("webdriver.chrome.driver", projectPath+ "/drivers/chromedriver/chromedriver.exe");


		WebDriver driver = new ChromeDriver();
		//System.setProperty("webdriver.gecko.driver", projectPath+"/drivers/geckodriver/geckodriver.exe");
		//WebDriver driver = new FirefoxDriver();
		// WebDriver driver = new RemoteWebDriver(new URL(URL), caps);

		/**
		 * Goes to Sauce Lab's guinea-pig page and prints title
		 */
		driver.get("https://google.com");
		System.out.println(driver.getTitle());
		//driver.findElement(By.name("q")).clear();
		driver.findElement(By.name("q")).sendKeys("automation test step by step");
		driver.findElement(By.name("btnK")).sendKeys(Keys.RETURN);
		//driver.get("https://saucelabs.com/test/guinea-pig");
		System.out.println("Title of page is: " + driver.getTitle());

		driver.quit();
		System.out.println("Test Completed");
	}
}