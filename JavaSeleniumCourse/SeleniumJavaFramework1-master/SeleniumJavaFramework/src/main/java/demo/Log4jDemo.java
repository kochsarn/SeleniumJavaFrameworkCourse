package demo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.message.LoggerNameAwareMessage;

public class Log4jDemo {
	 private static Logger logger = LogManager.getLogger(Log4jDemo.class);

	public static void main(String[] args) {
		System.out.println("\n Hello World...!   \n");
	    logger.trace("This is trace message");
		logger.info("This is information message");
		logger.error("This"+ " is error message");
				
		logger.warn("This is warning message");
		logger.fatal("This is Fatal message");
		
        System.out.println("\n Completed");
	}

}
