package com.jmzombe.log4j2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Logging {

  public static void main(String[] args) {
	  Logger log = LogManager.getLogger(Logging.class.getName());
	     
   	  log.debug("Debug");   // show debug, info, warning, error, fatal
   	  log.info("Info");     // show info, warning, error, fatal
      log.warn("Warning");  // show warning, error, fatal
      log.error("Error");   // show error, fatal
      log.fatal("Fatal");   // show fatal
      log.trace("Trace");   // show debug, info, warning, error, fatal, trace
  }
}
