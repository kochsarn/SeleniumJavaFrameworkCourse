package demo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MainApp {
	 private static final Logger logger = LogManager.getLogger(MainApp.class);

	   public static void main(String[] args) {

	      logger.trace("Entering application...");

	      logger.info("Hello Log4j2...");
	      logger.error("Something is wrong with this code Invalid message");
	      logger.trace("Exiting application...");
	   }
}
