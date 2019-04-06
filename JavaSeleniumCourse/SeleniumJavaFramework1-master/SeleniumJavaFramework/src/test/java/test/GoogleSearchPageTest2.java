package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.GoogleSearchPageObjects;

public class GoogleSearchPageTest2 {
	public static WebDriver driver = null;
	public static void main(String[] args) {
		googleSearchTest();
	}

	public static void googleSearchTest()  {
		
		String projectPath = System.getProperty("user.dir"); 
		System.setProperty("webdriver.chrome.driver", projectPath+ "/drivers/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		GoogleSearchPageObjects searchPageobj = new GoogleSearchPageObjects(driver);
		driver.get("https://google.com");
		searchPageobj.setTextInSearchBox("Hello google test");
		searchPageobj.clickSearchButton();
		try {
			Thread.sleep(8000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		driver.close();
		}
	}
