package demo;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutoITDemo {
	public static void main(String[] args) throws Exception {
		test();
	}
	public static void test() throws Exception {
		String projectPath = System.getProperty("user.dir");
		System.out.println("projectpath :"+projectPath);
		System.setProperty("webdriver.chrome.driver", projectPath+ "/drivers/chromedriver/chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.get("http://www.tinyupload.com/");
		driver.findElement(By.name("uploaded_file")).click();
		Runtime.getRuntime().exec("D:/FileUploadScript.exe");
		Thread.sleep(8000);
		driver.close();

	}
}
