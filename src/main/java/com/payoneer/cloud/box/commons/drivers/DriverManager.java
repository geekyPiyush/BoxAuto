package com.payoneer.cloud.box.commons.drivers;

import com.payoneer.cloud.box.commons.logger.Log;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.util.ArrayList;
import java.util.List;

public class DriverManager {
  private static ThreadLocal<WebDriver> webDriver = new ThreadLocal<WebDriver>();
  private static List<WebDriver> storedDrivers = new ArrayList<>();

//  static {
//    Runtime.getRuntime().addShutdownHook(new Thread() {
//      public void run() {
//        storedDrivers.forEach(WebDriver::quit);
//      }
//    });
//  }

  private DriverManager() {
  }

  public static void addDriverIfNull() {
    if (getDriver() == null) {
      String browser = System.getProperty("browser");
      switch (browser) {
        case "chrome":
            addDriver(new ChromeDriver());
          break;
        case "firefox":
          addDriver(new FirefoxDriver());
          break;
        case "safari":
          addDriver(new SafariDriver());
          break;
      }
    }
  }

  public static WebDriver getDriver() {
    return webDriver.get();
  }

  public static void addDriver(WebDriver driver) {
    storedDrivers.add(driver);
    Log.info("Adding driver -->> " + driver.toString());
    int width = Integer.parseInt(DesktopBrowserDriver.desktopBrowser.get("width"));
    int height = Integer.parseInt(DesktopBrowserDriver.desktopBrowser.get("height"));
    driver.manage().window().setSize(new Dimension(width,height));
    webDriver.set(driver);
  }

  public static void setWebDriver(WebDriver driver) {
    webDriver.set(driver);
  }

  public static void quitWebDriver() {
    WebDriver driver = webDriver.get();
    if (driver != null) {
      Log.info("Quitting webdriver");
      driver.quit();
    }
  }

}