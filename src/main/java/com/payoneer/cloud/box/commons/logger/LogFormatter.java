package com.payoneer.cloud.box.commons.logger;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;

public class LogFormatter extends Formatter {
  // ANSI escape code
  public static final String ANSI_RESET = "\u001B[0m";
  public static final String ANSI_RED = "\u001B[31m";
  public static final String ANSI_GREEN = "\u001B[32m";
  public static final String ANSI_YELLOW = "\u001B[33m";
  public static final String ANSI_BLUE = "\u001B[34m";
  public static final String ANSI_PURPLE = "\u001B[35m";
  public static final String ANSI_WHITE = "\u001B[37m";

  // format is called for every console log message
  @Override
  public String format(LogRecord record) {
    // This example will print date/time, class, and log level in yellow,
    // followed by the log message and it's parameters in white .
    StringBuilder builder = new StringBuilder();
    String level = record.getLevel().getName();
    switch (level) {
    case "DEBUG":
      builder.append(ANSI_PURPLE);
      break;
    case "INFO":
      builder.append(ANSI_BLUE);
      break;
    case "WARNING":
      builder.append(ANSI_YELLOW);
      break;
    case "SEVERE":
      builder.append(ANSI_RED);
      break;
    case "FINE":
      builder.append(ANSI_GREEN);
      break;
    default:
      builder.append(ANSI_GREEN);
      break;
    }

    builder.append("\n[");
    builder.append(calcDate(record.getMillis()));
    builder.append("]");

    builder.append(" [");
    builder.append(level);
    builder.append("]");

    builder.append(ANSI_WHITE);
    builder.append(" ");
    builder.append(record.getMessage());

    Object[] params = record.getParameters();

    if (params != null) {
      builder.append("\t");
      for (int i = 0; i < params.length; i++) {
        builder.append(params[i]);
        if (i < params.length - 1)
          builder.append(", ");
      }
    }

    builder.append(ANSI_RESET);
    builder.append("\n");
    return builder.toString();
  }

  private String calcDate(long millisecs) {
    SimpleDateFormat date_format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    Date resultdate = new Date(millisecs);
    return date_format.format(resultdate);
  }

}