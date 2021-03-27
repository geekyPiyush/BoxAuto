package com.payoneer.cloud.box.commons.drivers;

import com.payoneer.cloud.box.commons.factory.DeviceMetricsFactory;
import com.payoneer.cloud.box.commons.logger.Log;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.util.Map;

public class DesktopBrowserDriver {

    public static Map<String, String> desktopBrowser;

    public static WebDriver create(String id) {

        desktopBrowser = DeviceMetricsFactory.desktopBrowsers.get(id);
        Log.info("Creating Driver for -->> ", desktopBrowser.toString());
        WebDriver driver = null;
        switch (desktopBrowser.get("name")) {
            case "Chrome":
                driver = new ChromeDriver();
                break;
            case "Firefox":
                driver = new FirefoxDriver();
                break;
            case "Safari":
                driver = new SafariDriver();
                break;
        }
        try {
            int width = Integer.parseInt(desktopBrowser.get("width"));
            int height = Integer.parseInt(desktopBrowser.get("height"));
            Dimension dim = new Dimension(width, height);
            driver.manage().window().setSize(dim);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return driver;
    }
}