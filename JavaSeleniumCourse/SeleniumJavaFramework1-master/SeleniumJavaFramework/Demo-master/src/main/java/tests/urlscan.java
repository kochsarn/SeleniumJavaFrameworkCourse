package tests;

import com.applitools.eyes.selenium.fluent.Target;
import com.applitools.eyes.selenium.Eyes;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class urlscan {

    public static void scanlist(RemoteWebDriver driver, Eyes eyes, String urlList){

        int i;
        long before;

        before = System.currentTimeMillis();
        urlscan wantFile = new urlscan();

        System.out.println("Scanning URL's in " + urlList);
        String[] arr = new String[0];
        try {
            Scanner sc = new Scanner(wantFile.getFile(urlList));
            List<String> lines = new ArrayList<String>();
            while (sc.hasNextLine()) {
                lines.add(sc.nextLine());
            }
            arr = lines.toArray(new String[0]);
            System.out.println("URL's to check: " + arr.length);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        for(i=0;i<arr.length;i++){
            before = System.currentTimeMillis();
            System.out.println("Checking URL " + +i + ": " + arr[i]);
            try {
                driver.get(arr[i]);
                utils.page.arrowDown(driver);
                utils.page.suspend(1000);
                utils.page.changePage(driver);
                eyes.check(arr[i], Target.window());
            } catch (Exception e) {
                System.out.println("FAILED URL " + +i + " in " + (System.currentTimeMillis() - before) + "ms");
                e.printStackTrace();
            }
        }
        System.out.println("Scanned URL's in " + (System.currentTimeMillis() - before) + "ms");
    }

    public File getFile(String fileName){

        ClassLoader classLoader = getClass().getClassLoader();
        File file = null;
        try {
            file = new File(classLoader.getResource(fileName).getFile());
        } catch (Exception e) {
            System.out.println("Fiel Not Found: " + fileName);
            e.printStackTrace();
        }
        return file;
    }
}
