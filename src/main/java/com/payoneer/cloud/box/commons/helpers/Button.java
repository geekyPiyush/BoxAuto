package com.payoneer.cloud.box.commons.helpers;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Button {
  public static void safeClick(WebDriver driver, WebElement element, Boolean checkVisibility) {
    ScrollPage.toElement(element);
    JavascriptExecutor executor = (JavascriptExecutor) driver;
    executor.executeScript("arguments[0].focus();", element);

    if (checkVisibility) {
      WebDriverWait wait = new WebDriverWait(driver, 5);
      wait.until(ExpectedConditions.visibilityOf(element));
      wait.until(ExpectedConditions.elementToBeClickable(element));
    }
    executor.executeScript("arguments[0].click();", element);
  }

  public static void safeClick(WebDriver driver, WebElement element) {
    // By default check visibility for all the buttons
    safeClick(driver, element, true);
  }
}