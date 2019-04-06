import com.applitools.eyes.BatchInfo;
import com.applitools.eyes.FileLogger;
import com.applitools.eyes.RectangleSize;
import com.applitools.eyes.selenium.Eyes;
import com.applitools.eyes.selenium.StitchMode;
import com.applitools.eyes.selenium.fluent.Target;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import utils.params;

import java.util.concurrent.TimeUnit;

public class sandbox {

    protected RemoteWebDriver driver;

    protected Eyes eyes;

    private static final String BATCH_NAME = params.BATCH_NAME;
    private static final String BATCH_ID = params.BATCH_ID;
    private static final String APP_NAME = params.APP_NAME;

    @Parameters({"platformName", "platformVersion", "browserName", "browserVersion"})
    @Test(priority = 1, alwaysRun = true, enabled = true)
    public void MagicLeap(String platformName ,String platformVersion,
                       String browserName, String browserVersion) {

        Integer i=0;
        String testName = params.TEST_NAME;
        long before;

        //Force to check against specific baseline branch
        //eyes.setBaselineBranchName("Perdue Global Firefox");
        //Force to check with the forced baselines corresponding environment
        //eyes.setBaselineEnvName("sandbox");

        //Set the environment name in the test batch results
        //eyes.setEnvName(driver.getCapabilities().getBrowserName() + " " + driver.getCapabilities().getVersion());

        eyes.setMatchLevel(params.MATCH_MODE);
        eyes.setStitchMode(StitchMode.CSS);
        //eyes.setForceFullPageScreenshot(true);
        eyes.setSendDom(true);

        eyes.open(driver,APP_NAME, testName, new RectangleSize(1200, 900));

        driver.get("https://www.magicleap.com");
        eyes.check("Home Page A", Target.window());
        utils.page.arrowDown(driver);
        eyes.check("Home Page B", Target.window());
        utils.page.arrowDown(driver);
        eyes.check("Home Page C", Target.window());

        driver.get("https://www.magicleap.com/experiences");
        eyes.check("Experiences", Target.window().fully());

        driver.get("https://www.magicleap.com/creator");
        eyes.check("Creator", Target.window().fully());

        eyes.close();
    }

    @Parameters({"platformName", "platformVersion", "browserName", "browserVersion"})
    @Test(priority = 1, alwaysRun = true, enabled = false)
    public void Perdue(String platformName ,String platformVersion,
                         String browserName, String browserVersion) {

        Integer i=0;
        String testName = params.TEST_NAME;
        long before;

        //Force to check against specific baseline branch
        //eyes.setBaselineBranchName("Perdue Global Firefox");
        //Force to check with the forced baselines corresponding environment
        //eyes.setBaselineEnvName("sandbox");

        //Set the environment name in the test batch results
        //eyes.setEnvName(driver.getCapabilities().getBrowserName() + " " + driver.getCapabilities().getVersion());

        eyes.setMatchLevel(params.MATCH_MODE);
        eyes.setStitchMode(StitchMode.CSS);
        eyes.setForceFullPageScreenshot(true);
        eyes.setSendDom(true);

        eyes.open(driver,APP_NAME, testName, new RectangleSize(1200, 900));

        driver.get("https://enroll-app.purdueglobal.edu/personal-information");

        //Capture entire window
        eyes.check("Whole Page", Target.window().fully());

        //Capture the firstName element
        eyes.check("First Name", Target.region(By.id("firstName")));

        eyes.close();
    }


    @Parameters({"platformName", "platformVersion", "browserName", "browserVersion"})
    @BeforeClass(alwaysRun = true)
    public void baseBeforeClass(String platformName ,String platformVersion,
                                String browserName, String browserVersion) {

        String threadId = Long.toString(Thread.currentThread().getId());
        long before = System.currentTimeMillis();

        eyes = utils.myeyes.getEyes(threadId);
        eyes.setLogHandler(new FileLogger("log/file.log",true,true));

        BatchInfo batchInfo = new BatchInfo(BATCH_NAME);
        if(BATCH_ID!=null) batchInfo.setId(BATCH_ID);
        eyes.setBatch(batchInfo);

        //driver = utils.drivers.getLocalChrome(threadId);
        driver = utils.drivers.getGrid(threadId, "firefox");
        driver.manage().timeouts().setScriptTimeout(90, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(90, TimeUnit.SECONDS);


        //Allows for filtering dashboard view
        eyes.addProperty("SANDBOX", "YES");

        System.out.println("START THREAD ID - " + Thread.currentThread().getId() + " " + browserName + " " + browserVersion);
        System.out.println("baseBeforeClass took " + (System.currentTimeMillis() - before) + "ms");
    }

    @AfterClass(alwaysRun = true)
    public void baseAfterClass() {

        if (driver != null) {
            long before = System.currentTimeMillis();
            eyes.abortIfNotClosed();
            driver.quit();
            System.out.println("Driver quit took " + (System.currentTimeMillis() - before) + "ms");
        }


    }
}
