package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;


public class page {

    public static void click(WebDriver driver, String cssSelector) {
        try {
            driver.findElement(By.cssSelector(cssSelector)).click();
        } catch (Exception e) {

        }
    }
    public static void pageDown(RemoteWebDriver driver){

        Long height = (Long) driver.executeScript("return document.body.scrollHeight;");

        Actions builder = new Actions(driver);
        Action seriesOfActions = builder
                .sendKeys(Keys.PAGE_DOWN)
                .build();

        Integer i=0;
        for(i=0;i<height/800;i++) {
            seriesOfActions.perform();
        }
        seriesOfActions = builder
                .sendKeys(Keys.HOME)
                .build();
        seriesOfActions.perform();
    }

    public static void arrowDown(RemoteWebDriver driver){

        Long height = (Long) driver.executeScript("return document.body.scrollHeight;");

        Actions builder = new Actions(driver);
        Action seriesOfActions = builder
                .sendKeys(Keys.ARROW_DOWN)
                .build();

        Integer i=0;
        for(i=0;i<height/4;i++) {
            seriesOfActions.perform();
        }
    }


    public static void home(RemoteWebDriver driver){

        Actions builder = new Actions(driver);
        Action seriesOfActions = builder
            .sendKeys(Keys.HOME)
            .build();
        seriesOfActions.perform();
    }

    public static void suspend(int millis) {
        try {
            Thread.sleep(millis);
        } catch (Exception e) {

        }
    }

    public static void changePage(RemoteWebDriver driver){

        String script = "" +
                "                                    var elements = window.document.querySelectorAll(\"body, body *\");\n" +
                "                                    var child;\n" +
                "                                    for(var i = 0; i < elements.length; i++) {\n" +
                "                                        child = elements[i].childNodes[0];\n" +
                "                                        if(elements[i].hasChildNodes() && child.nodeType == 3) {\n" +
                "                                           child.nodeValue = child.nodeValue.replace('o','0');" +
                "                                        }\n" +
                "                                    }\n";
        if(params.changePage) {
            driver.executeScript(script);
        }
    }
}
