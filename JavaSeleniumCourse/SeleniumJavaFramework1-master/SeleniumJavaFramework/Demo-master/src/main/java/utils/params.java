package utils;

import com.applitools.eyes.MatchLevel;

public class params {

    public static String EYES_KEY = System.getProperty("eyesAPIKey", "DEFAULT_TOKEN");
    public static String GRID_URL = "http://localhost:4444/wd/hub";

    private static String name = "url";

    public static String BATCH_NAME = name + "";
    public static String APP_NAME = name + "";
    public static String TEST_NAME = name + "";
    public static String URL_FILE = name + ".csv";

    public static MatchLevel MATCH_MODE = MatchLevel.STRICT;
    public static String BATCH_ID = null;

    public static Boolean FULL_SCREEN = false;

    public static Boolean changePage = false;  // to change the content for demo purposes

    public static Boolean DISABLE_EYES = false;
}

