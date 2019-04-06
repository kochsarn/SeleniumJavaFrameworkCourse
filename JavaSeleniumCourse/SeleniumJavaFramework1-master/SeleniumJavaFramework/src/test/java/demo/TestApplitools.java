package demo;
import com.applitools.eyes.*;
import com.applitools.eyes.RectangleSize;
import com.applitools.eyes.selenium.Eyes;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

public class TestApplitools {
	public static void main(String[] args) throws IOException {

		Eyes eyes = new Eyes();

		// Initialize the eyes SDK and set your private API key.
		eyes.setApiKey("XJOAUur9RmBlwPYMcMlAtj6E106WI8HpU8FryB5pMSV108g110");

		// Define the OS and hosting application to identify the baseline.
		eyes.setHostOS("Windows 10");
		eyes.setHostApp("My maxthon browser");

		BufferedImage img;

		try {

			// Start the test with a viewport size of 800x600.
			eyes.open(null, "Applitools site", "Java Screenshot test!", new RectangleSize(800, 600));

			// Load page image and validate.
			img = ImageIO.read(new URL("https://applitools.com/tutorials/applitools.jpg"));

			// Visual validation.
			//eyes.checkImage(img, "Contact-us page");

			// End visual UI testing.
			eyes.close();

		} finally {

			// If the test was aborted before eyes.close was called, ends the test as aborted.
			eyes.abortIfNotClosed();

		}
	}
}

