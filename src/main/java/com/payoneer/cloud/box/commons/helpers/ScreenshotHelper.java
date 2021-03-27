package com.payoneer.cloud.box.commons.helpers;

import com.payoneer.cloud.box.commons.drivers.DriverManager;
import com.payoneer.cloud.box.commons.logger.Log;
import cucumber.api.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

import java.util.ArrayList;
import java.util.List;

public class ScreenshotHelper {

  public static List<Scenario> failedScenarioList = new ArrayList<>();
    public static void takeScreenshotWhenFails(Scenario scenario) {
        WebDriver driver = DriverManager.getDriver();
        if (driver != null && scenario.isFailed()) {
            System.out.println("Scenario failed is ");
            try {
                Log.warning("Taking screenshot of failed area for scenario -->> " + scenario.getName());
                failedScenarioList.add(scenario);
              scenario.write("Page URL " + driver.getCurrentUrl());
              byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
              scenario.embed(screenshot, "image/png");
            } catch (WebDriverException e) {
              scenario.write("Current platform may not support screenshots!");
              scenario.write(e.getMessage());
            }
          }
    }
}

