package test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.googleSearchPage;

public class GoogleSearchTest {

	private static WebDriver driver = null;

	public static void main(String[] args) {
		googleSearch();
	}


	public static void googleSearch()  {

		String projectPath = System.getProperty("user.dir"); 
		System.setProperty("webdriver.chrome.driver", projectPath+ "/drivers/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		// goto google.com
		driver.get("https://google.com");
		//driver.findElement(By.name("q")).sendKeys("Automation Step By Step");
		googleSearchPage.textbox_search(driver).sendKeys("Automation step by step");

		// Click on search button
		// driver.findElement(By.name("btnK")).click();
		//driver.findElement(By.name("btnK")).sendKeys(Keys.RETURN);

		googleSearchPage.button_search(driver).sendKeys(Keys.RETURN);

		// close browser
		
				
		driver.close();
		System.out.println("Test Completed Successfully");

	} 

}
