package com.payoneer.cloud.box.steps;

import com.payoneer.cloud.box.commons.drivers.DriverManager;

import com.payoneer.cloud.box.commons.factory.LoginFactory;
import com.payoneer.cloud.box.commons.helpers.Button;
import com.payoneer.cloud.box.commons.helpers.ElementVisibility;
import com.payoneer.cloud.box.commons.helpers.InputTextHelper;
import com.payoneer.cloud.box.commons.helpers.RandomGen;
import com.payoneer.cloud.box.constants.BoxPageLocators;
import com.payoneer.cloud.box.pageobjects.SignInPageObject;
import com.payoneer.cloud.box.pageobjects.UserDashboardPageObject;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.Map;

public class SignInPageStepDefs {

    private WebDriver driver;
    private SignInPageObject signInPageObject;
    private UserDashboardPageObject userDashboardPageObject;

    public SignInPageStepDefs() {
        DriverManager.addDriverIfNull();
        // gets the web driver
        driver = DriverManager.getDriver();
        signInPageObject = new SignInPageObject(driver);
        userDashboardPageObject = new UserDashboardPageObject(driver);
    }

    @And("I enter user credentials to login to account$")
    public void i_enter_user_crendentials_to_login() throws InterruptedException {
        Map<String, String> creds = LoginFactory.getUserCredentials();
        InputTextHelper.sendKeys(driver, signInPageObject.userNameInput(), creds.get("userName"));
        Button.safeClick(driver, signInPageObject.loginSubmit());
        Thread.sleep(1000);
        InputTextHelper.sendKeys(driver, signInPageObject.passwordInput(), creds.get("password"));
        Button.safeClick(driver, signInPageObject.loginSubmitPassword());
    }

    @And("I enter invalid user credentials to login to account: ([^\"]*) ([^\"]*)$")
    public void i_enter_invalid_user_crendentials_to_login(String username, String password) throws InterruptedException {
        String randUser = RandomGen.generateRandomInteger(500) + username;
        InputTextHelper.sendKeys(driver, signInPageObject.userNameInput(), randUser);
        signInPageObject.loginSubmit().click();
        Thread.sleep(1000);
        InputTextHelper.sendKeys(driver, signInPageObject.passwordInput(), password);
        signInPageObject.loginSubmitPassword().click();
    }

    @Then("I verify user is logged in to system$")
    public void verify_user_logged_in() {
        Assert.assertTrue(ElementVisibility.isElementPresent(driver, BoxPageLocators.userAvatar), "User unable to logged in");
    }

    @Then("I verify user gets invalid credential message$")
    public void verify_invalid_cred_message() {
        Assert.assertTrue(ElementVisibility.isElementPresent(driver, BoxPageLocators.invalidCredMessage), "-- Invalid credentials should be displayed --");
        Assert.assertFalse(ElementVisibility.isElementPresent(driver, BoxPageLocators.userAvatar), "-- User unable to logged in --");
    }
}
