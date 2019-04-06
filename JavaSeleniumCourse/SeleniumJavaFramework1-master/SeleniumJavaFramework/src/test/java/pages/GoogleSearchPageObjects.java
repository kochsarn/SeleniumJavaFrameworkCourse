package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class GoogleSearchPageObjects {
	
	WebDriver driver = null;
	By textbox_search = By.name("q");
	
	//By textbox_search = By.id("lst-ib");
	By botton_search =  By.name("btnK");
	
	public GoogleSearchPageObjects(WebDriver driver){
		this.driver = driver;
	} 

	public void setTextInSearchBox(String text){
		driver.findElement(textbox_search).sendKeys(text);
	}

	public void clickSearchButton() {
		driver.findElement(botton_search).sendKeys(Keys.RETURN);
	}	

}
