package com.payoneer.cloud.box.steps;

import com.payoneer.cloud.box.commons.drivers.DriverManager;
import com.payoneer.cloud.box.commons.factory.EnvironmentFactory;
import com.payoneer.cloud.box.commons.helpers.ElementVisibility;
import com.payoneer.cloud.box.constants.BoxPageLocators;
import com.payoneer.cloud.box.pageobjects.SignInPageObject;
import cucumber.api.java.en.And;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CommonIconsStepDefs {

    private WebDriver driver;
    private SignInPageObject signInPageObject;

    public CommonIconsStepDefs() {
        DriverManager.addDriverIfNull();
        // gets the web driver
        driver = DriverManager.getDriver();
        signInPageObject = new SignInPageObject(driver);
    }

    @And("I go to box cloud application$")
    public void i_go_to_Page() {
        String url = EnvironmentFactory.getUrl();
        driver.get(url);
        ElementVisibility.setDefaultImplicitlyWait(driver);

        Assert.assertTrue(ElementVisibility.isElementPresent(driver, BoxPageLocators.boxLogo), "Box home page should be displayed");
    }

    @And("^I refresh page$")
    public void i_refresh_page() {
        driver.navigate().refresh();
    }

}
