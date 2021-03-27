package com.payoneer.cloud.box.commons.helpers;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Coordinates;
import org.openqa.selenium.interactions.Locatable;

public class ScrollPage {
    //method to scroll
    public static void toElement(WebElement scrollToThisElement) {
        try {
            Coordinates coordinate = ((Locatable) scrollToThisElement).getCoordinates();
            coordinate.onPage();
            coordinate.inViewPort();
        } catch (Exception e) {
            System.out.println("Element is not visible in page." + e.toString());
        }
    }
}
