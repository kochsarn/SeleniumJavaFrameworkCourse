import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BrowserTest {

	public static void main(String[] args) {
		
		String projectPath = System.getProperty("user.dir");
		System.out.println("projectpath :"+projectPath);
		
		//System.setProperty("webdriver.gecko.driver", projectPath+"/drivers/geckodriver/geckodriver.exe");
		//WebDriver driver = new FirefoxDriver();
		  System.setProperty("webdriver.chrome.driver", projectPath+ "/drivers/chromedriver/chromedriver.exe");
		
		
		 WebDriver driver = new ChromeDriver();
		//System.setProperty("webdriver.ie.driver", projectPath+ "/drivers/iedriver/IEDriverServer.exe");
		//WebDriver driver = new InternetExplorerDriver();
		
	/*	driver.get("http://seleniumhq.org/ ");	*/
	//	driver.get("http://www.github.com/ ");	
			driver.get("http://seleniumhq.org/ ");		
			  
 try {
	Thread.sleep(3000);
} catch (InterruptedException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}

 // driver.get("http://www.github.com/ ");   	
		    driver.close();
		  
		   
			//driver.quit();
			} 
}
