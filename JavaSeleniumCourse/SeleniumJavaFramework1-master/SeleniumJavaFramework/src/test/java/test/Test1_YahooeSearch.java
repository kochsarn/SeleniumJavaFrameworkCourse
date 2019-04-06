package test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test1_YahooeSearch {
 public static void main(String[] args) {
	 yahooSearch();
 }
 

 public static void yahooSearch() {
	 
	 String projectPath = System.getProperty("user.dir"); 
	 System.setProperty("webdriver.chrome.driver", projectPath+ "/drivers/chromedriver/chromedriver.exe");
     WebDriver driver = new ChromeDriver();
	// goto google.com
     driver.get("https://yahoo.com");
     driver.findElement(By.name("p")).sendKeys("Automation Step By Step");
     // Click on search button
     // driver.findElement(By.name("btnK")).click();
     driver.findElement(By.id("uh-search-button")).sendKeys(Keys.RETURN);
     // close browser
     
     try {
		Thread.sleep(7000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
     driver.close();
     System.out.println("Test Completed Successfully");
     
} 
 	
}
