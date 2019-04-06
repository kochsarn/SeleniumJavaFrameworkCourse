/**
 * Created by Sanderson on 26/01/2017.
 */


import com.applitools.eyes.Eyes;
import com.applitools.eyes.RectangleSize;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.net.URISyntaxException;

public class TestApplitoolsWebsite {


	public static void main(String[] args) throws URISyntaxException, InterruptedException {
		String projectPath = System.getProperty("user.dir");
		System.out.println("projectpath :"+projectPath);

		System.setProperty("webdriver.gecko.driver", projectPath+"/drivers/geckodriver/geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		// System.setProperty("webdriver.chrome.driver", projectPath+ "/drivers/chromedriver/chromedriver.exe");

		// WebDriver driver = new ChromeDriver();
		WebDriver driver = new FirefoxDriver();

		Eyes eyes = new Eyes();
		// This is your api key, make sure you use it in all your tests.
		// eyes.setApiKey(System.getenv("EYESKEY"));
		eyes.setApiKey(System.getenv("XJOAUur9RmBlwPYMcMlAtj6E106WI8HpU8FryB5pMSV108g110"));

		try {
			// Start visual testing with browser viewport set to 1158x572.
			// Make sure to use the returned driver from this point on.
			driver = eyes.open(driver, "Applitools", "Test Web Page", new RectangleSize(1158,572));

			driver.get("http://applitools.com");

			// Visual validation point #1
			eyes.checkWindow("Main Page");

			driver.findElement(By.cssSelector(".features>a")).click();

			// Visual validation point #2
			eyes.checkWindow("Features page");

			// End visual testing. Validate visual correctness.
			eyes.close();
		} finally {
			// Abort test in case of an unexpected error.
			eyes.abortIfNotClosed();
			driver.close();
		}
	}


}
