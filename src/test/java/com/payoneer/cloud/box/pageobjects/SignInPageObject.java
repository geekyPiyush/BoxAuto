package com.payoneer.cloud.box.pageobjects;

import com.payoneer.cloud.box.constants.BoxPageLocators;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SignInPageObject {
    private WebDriver driver;

    public SignInPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement loginButton() {
        return driver.findElement(BoxPageLocators.loginButton);
    }

    public WebElement loginContainer() { return  driver.findElement(BoxPageLocators.loginContainer);}

    public WebElement userNameInput() { return driver.findElement(BoxPageLocators.userNameInput);}

    public WebElement passwordInput() { return driver.findElement(BoxPageLocators.passwordInput);}

    public WebElement loginSubmit() { return driver.findElement(BoxPageLocators.loginSubmit);}

    public WebElement loginSubmitPassword() { return driver.findElement(BoxPageLocators.loginSubmitPassword);}

    public WebElement invalidCredMessage() { return driver.findElement(BoxPageLocators.invalidCredMessage);}

}