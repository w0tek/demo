package com.example.demo.book.logger;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class LoggerClassExample {

	Logger logger = LogManager.getLogger(LoggerClassExample.class);

	public void logSomething() {
		logger.info("Info");
		logger.warn("Warn");
		logger.error("Error");
	}
}
