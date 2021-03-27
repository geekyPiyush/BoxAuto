package com.payoneer.cloud.box.steps;

import com.payoneer.cloud.box.commons.drivers.DriverManager;
import com.payoneer.cloud.box.commons.helpers.ElementVisibility;
import com.payoneer.cloud.box.constants.BoxPageLocators;
import com.payoneer.cloud.box.pageobjects.SignInPageObject;
import cucumber.api.java.en.And;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class HomePageStepDefs {

    private WebDriver driver;
    private SignInPageObject signInPageObject;

    public HomePageStepDefs() {
        DriverManager.addDriverIfNull();
        // gets the web driver
        driver = DriverManager.getDriver();
        signInPageObject = new SignInPageObject(driver);
    }

    @And("I click on Login button")
    public void i_click_on_login_button() {
        signInPageObject.loginButton().click();
        Assert.assertTrue(ElementVisibility.isElementPresent(driver, BoxPageLocators.loginContainer), "-- Login card should be visible --");
    }


}
