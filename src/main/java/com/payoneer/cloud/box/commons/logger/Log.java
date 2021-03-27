package com.payoneer.cloud.box.commons.logger;

import java.util.logging.ConsoleHandler;
import java.util.logging.Formatter;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Log {
  static Logger logger;

  static {
    logger = Logger.getLogger(Log.class.getName());
    logger.setUseParentHandlers(false);

    ConsoleHandler handler = new ConsoleHandler();
    Formatter formatter = new LogFormatter();
    
    handler.setFormatter(formatter);
    logger.addHandler(handler);
    logger.setLevel(Level.FINE);
  }

  public static void info(String... args){
    logger.info(String.join(" ", args));
  }

  public static void warning(String... args){
    logger.warning(String.join(" ", args));
  }

}