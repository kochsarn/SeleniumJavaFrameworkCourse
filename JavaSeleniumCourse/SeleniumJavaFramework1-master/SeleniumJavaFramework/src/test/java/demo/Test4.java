package demo;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Test4 {
	private WebDriver driver;
	private String baseUrl;
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();

	@BeforeClass(alwaysRun = true)
	public void setUp() throws Exception {
		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath+ "/drivers/chromedriver/chromedriver.exe"); 
		//driver = new FirefoxDriver();
		driver = new ChromeDriver();
		baseUrl = "https://www.katalon.com/";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void test4() throws Exception {
		driver.get("https://www.google.com/");
		driver.findElement(By.name("q")).click();
		driver.findElement(By.name("q")).clear();
		driver.findElement(By.name("q")).sendKeys("apple");
		driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='à¸„à¸­à¸¥à¹€à¸¥à¹‡à¸�à¸Šà¸±à¸™'])[1]/following::span[4]")).click();
		// ERROR: Caught exception [ERROR: Unsupported command [doubleClick | xpath=(.//*[normalize-space(text()) and normalize-space(.)='à¸¥à¸š'])[11]/following::div[5] | ]]
		driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='à¹ƒà¸�à¸¥à¹‰à¹€à¸„à¸µà¸¢à¸‡'])[1]/following::h3[1]")).click();
		driver.findElement(By.id("login_u")).click();
		driver.findElement(By.id("login_u")).clear();
		driver.findElement(By.id("login_u")).sendKeys("0007129");
		driver.findElement(By.id("login_p")).click();
		driver.findElement(By.id("login_p")).clear();
		driver.findElement(By.id("login_p")).sendKeys("young1104");
		driver.findElement(By.id("style-signin")).click();
		// ERROR: Caught exception [ERROR: Unsupported command [selectFrame | index=1 | ]]
		driver.findElement(By.id("settrade")).click();
		// ERROR: Caught exception [ERROR: Unsupported command [selectWindow | win_ser_1 | ]]
		// ERROR: Caught exception [ERROR: Unsupported command [selectWindow | win_ser_local | ]]
		// ERROR: Caught exception [ERROR: Unsupported command [selectFrame | index=1 | ]]
		driver.findElement(By.id("aspen")).click();
		// ERROR: Caught exception [ERROR: Unsupported command [selectWindow | win_ser_2 | ]]
		driver.findElement(By.id("imgStart")).click();
	}

	@AfterClass(alwaysRun = true)
	public void tearDown() throws Exception {
		driver.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
	}

	private boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	private boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}
	}

	private String closeAlertAndGetItsText() {
		try {
			Alert alert = driver.switchTo().alert();
			String alertText = alert.getText();
			if (acceptNextAlert) {
				alert.accept();
			} else {
				alert.dismiss();
			}
			return alertText;
		} finally {
			acceptNextAlert = true;
		}
	}
}
