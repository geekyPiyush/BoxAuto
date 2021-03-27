package com.payoneer.cloud.box.commons.drivers;

import com.payoneer.cloud.box.commons.logger.Log;
import org.openqa.selenium.WebDriver;

public class DriverFactory {

    public static WebDriver createInstance(String category, String id) {
        Log.info("Category is " + category + " and id is  " + id);
        WebDriver driver = null;
        try {
            if ("desktop_browser".equals(category)) {
                driver = DesktopBrowserDriver.create(id);
            }
            return driver;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
}