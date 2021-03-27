package com.payoneer.cloud.box.commons.helpers;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class InputTextHelper {

  public static void sendKeys(WebDriver driver, WebElement element, String str) {
    // shouldn't trim and shouldn't validate the str value here
    ScrollPage.toElement(element);
    ElementVisibility.waitUntilElementIsVisible(element, driver);
    element.sendKeys(str);
  }

  public static void clearAndSendKeys(WebDriver d, WebElement e, String newValue) {
    new Actions(d).click(e).
      sendKeys(Keys.END).keyDown(Keys.SHIFT).sendKeys(Keys.HOME).keyUp(Keys.SHIFT)
      .sendKeys(Keys.BACK_SPACE)
      .sendKeys(newValue)
      .perform();
  }

}