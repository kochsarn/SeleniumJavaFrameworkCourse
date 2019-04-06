package demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.android.AndroidDriver;
import java.net.URL;
import com.applitools.eyes.selenium.Eyes;

public class Appium_native_java {

	public static void main(String[] args) throws Exception {

		// Set desired capabilities.
		DesiredCapabilities capabilities = new DesiredCapabilities();

		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("deviceName", "DEVICE_NAME");
		capabilities.setCapability("platformVersion", "PLATFORM_VERSION");
		capabilities.setCapability("app", "http://saucelabs.com/example_files/ContactManager.apk");
		capabilities.setCapability("browserName", "");

		// Open the app.
		WebDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

		// Initialize the eyes SDK and set your private API key.
		Eyes eyes = new Eyes();
		eyes.setApiKey("XJOAUur9RmBlwPYMcMlAtj6E106WI8HpU8FryB5pMSV108g110");

		try {

			// Start the test.
			eyes.open(driver, "Contacts!", "My first Appium native Java test!");

			// Visual validation.
			eyes.checkWindow("Contact list!");

			// End the test.
			eyes.close();

		} finally {

			// Close the app.
			driver.quit();

			// If the test was aborted before eyes.close was called, ends the test as aborted.
			eyes.abortIfNotClosed();

		}

	}

}
