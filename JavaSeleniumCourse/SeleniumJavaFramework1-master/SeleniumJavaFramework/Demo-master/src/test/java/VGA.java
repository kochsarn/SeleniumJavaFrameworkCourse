



import com.applitools.eyes.*;
import com.applitools.eyes.config.SeleniumConfiguration;
import com.applitools.eyes.selenium.Eyes;
import com.applitools.eyes.selenium.StitchMode;
import com.applitools.eyes.selenium.fluent.Target;

import com.applitools.eyes.visualgridclient.model.*;
import com.applitools.eyes.visualgridclient.services.VisualGridRunner;

import com.applitools.utils.GeneralUtils;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import utils.params;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;




public class VGA {

    // This is to be used with 3.149.1-beta

    protected ChromeDriver driver;


    private VisualGridRunner renderingManager;
    private Eyes eyes;
    private SeleniumConfiguration seleniumConfiguration;
    private Logger logger;


    private static final String APP_NAME = params.APP_NAME;


    @Parameters({"platformName", "platformVersion", "browserName", "browserVersion"})
    @Test(priority = 1, alwaysRun = true, enabled = true)
    public void CheckURL(String platformName ,String platformVersion,
                         String browserName, String browserVersion) {

        Integer i=0;
        long before = 0;

        //Force to check against specific baseline branch
        //eyes.setBaselineBranchName("LLFireFox");
        //Force to check witht he forced baselines corresponding environment
        //eyes.setBaselineEnvName("firefox 63.0.3");

        //Set the environment name in the test batch results
        //eyes.setEnvName(driver.getCapabilities().getBrowserName() + " " + driver.getCapabilities().getVersion());

        eyes.setMatchLevel(params.MATCH_MODE);
        eyes.setStitchMode(StitchMode.CSS);
        eyes.setSendDom(true);

        seleniumConfiguration.setForceFullPageScreenshot(true);
        seleniumConfiguration.setTestName(params.TEST_NAME);
        seleniumConfiguration.setAppName(params.APP_NAME);
        eyes.setConfiguration(seleniumConfiguration);
        eyes.open(driver);

        String[] arr = new String[0];
        try {
            Scanner sc = new Scanner(new File("src/main/resources/" + params.URL_FILE));
            List<String> lines = new ArrayList<String>();
            while (sc.hasNextLine()) {
                lines.add(sc.nextLine());
            }
            arr = lines.toArray(new String[0]);
            System.out.println("URL's to check: " + arr.length);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        before = System.currentTimeMillis();
        for(i=0;i<arr.length;i++){
            System.out.println("Checking URL " + i + ": " + arr[i]);
            try {
                driver.get(arr[i]);
                utils.page.suspend(2000);
                utils.page.pageDown(driver);
                utils.page.changePage(driver);
                eyes.check(arr[i], Target.window());
            } catch (Exception e) {
                System.out.println("FAILED URL " + i + " in " + (System.currentTimeMillis() - before) + "ms");
                e.printStackTrace();
            }
        }
        //System.out.println("Closing eyes");
        //eyes.close();
        System.out.println("Completed URL Check in " + ((System.currentTimeMillis() - before))/1000 + "s");
        System.out.println("Waiting for Visual Grid Rendering ...");
        TestResultSummary allTestResults = renderingManager.getAllTestResults();
        System.out.println("Results: " + allTestResults);
    }


    @Parameters({"platformName", "platformVersion", "browserName", "browserVersion"})
    @BeforeClass(alwaysRun = true)
    public void baseBeforeClass(String platformName ,String platformVersion,
                                String browserName, String browserVersion) {

        String threadId = Long.toString(Thread.currentThread().getId());
        long before = System.currentTimeMillis();

        try {
            renderingManager = new VisualGridRunner(40);
            renderingManager.setLogHandler(new FileLogger(true));
            //renderingManager.setLogHandler(initLogHandler("visual_grid"));
            logger = renderingManager.getLogger();
            logger.log("enter");
            //renderingManager.setServerUrl(SERVER_URL);

            eyes = new Eyes(renderingManager);
            eyes.setApiKey(params.EYES_KEY);
            logger = eyes.getLogger();
            BatchInfo batchInfo = new BatchInfo(utils.params.BATCH_NAME);
            if(utils.params.BATCH_ID!=null) batchInfo.setId(utils.params.BATCH_ID);
            eyes.setBaselineEnvName("applitools environment");

            seleniumConfiguration = new SeleniumConfiguration();
            seleniumConfiguration.setBatch(batchInfo);
            String environment = utils.params.TEST_NAME + "Env";
            seleniumConfiguration.addBrowser(1600, 1200, SeleniumConfiguration.BrowserType.FIREFOX, environment);
            seleniumConfiguration.addBrowser(1600, 1200, SeleniumConfiguration.BrowserType.CHROME, environment);
            seleniumConfiguration.addBrowser(800, 600, SeleniumConfiguration.BrowserType.CHROME, environment);
            seleniumConfiguration.addBrowser(700, 500, SeleniumConfiguration.BrowserType.CHROME, environment);
            seleniumConfiguration.addBrowser(1200, 800, SeleniumConfiguration.BrowserType.CHROME, environment);
            seleniumConfiguration.addBrowser(1600, 1200, SeleniumConfiguration.BrowserType.CHROME, environment);


            EmulationDevice emulationDevice = new EmulationDevice(300, 400, 0.5f, true, ScreenOrientation.LANDSCAPE);
            EmulationInfo emulationInfo = new EmulationInfo(EmulationInfo.DeviceName.Galaxy_Note_II, ScreenOrientation.PORTRAIT);

            seleniumConfiguration.addDeviceEmulation(emulationDevice, environment);
            seleniumConfiguration.addDeviceEmulation(emulationInfo);


            logger.log("created configuration");
        } catch (Throwable e) {
            GeneralUtils.logExceptionStackTrace(logger, e);
        }

        driver = utils.drivers.getLocalChrome(threadId);

        // Allows for filtering dashboard view
       // eyes.addProperty("SANDBOX", "YES");

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
