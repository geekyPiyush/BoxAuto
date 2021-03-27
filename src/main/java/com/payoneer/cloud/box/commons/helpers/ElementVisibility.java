package com.payoneer.cloud.box.commons.helpers;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.remote.ErrorCodes.TIMEOUT;

public class ElementVisibility {

    public static void setImplicitlyWait(WebDriver driver, int seconds) {
        driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
    }

    public static void setDefaultImplicitlyWait(WebDriver driver) {
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    /**
     * Use this for elements which are affected by Scrolling
     *
     * @param webElement
     * @param driver
     */
    public static void waitUntilElementIsVisible(WebElement webElement, WebDriver driver) {
        setImplicitlyWait(driver, 0);
        WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);
        ExpectedCondition<Boolean> elementIsVisible = new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver arg0) {
                try {
                    return isVisibleInViewport(driver, webElement);
                } catch (NoSuchElementException e) {
                    return false;
                } catch (StaleElementReferenceException f) {
                    return false;
                }
            }
        };
        wait.until(elementIsVisible);
        setDefaultImplicitlyWait(driver);
    }

    public static Boolean isVisibleInViewport(WebDriver driver, WebElement element) {
        return (Boolean) ((JavascriptExecutor) driver).executeScript(
                "var elem = arguments[0],                 " + "  box = elem.getBoundingClientRect(),    "
                        + "  cx = box.left + box.width / 2,         " + "  cy = box.top + box.height / 2,         "
                        + "  e = document.elementFromPoint(cx, cy); " + "for (; e; e = e.parentElement) {         "
                        + "  if (e === elem)                        " + "    return true;                         "
                        + "}                                        " + "return false;                            ",
                element);
    }

    public static void waitUntilElementIsDisplayed(WebDriver driver, WebElement element, int timeoutInSec) {
        new WebDriverWait(driver, timeoutInSec)
                .until(ExpectedConditions.visibilityOf(element));
    }

    public static boolean isElementPresent(WebDriver driver, By locatorKey) {
        //Set implicity wait to 0 , so that webdriver does not implicity wait
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        try {
            driver.findElement(locatorKey);
            return true;
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        } finally {
            ElementVisibility.setDefaultImplicitlyWait(driver);
        }
    }
}
