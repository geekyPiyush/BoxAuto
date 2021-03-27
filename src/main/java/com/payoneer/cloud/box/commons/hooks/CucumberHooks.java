package com.payoneer.cloud.box.commons.hooks;

import com.payoneer.cloud.box.commons.helpers.ScreenshotHelper;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.AfterStep;

public class CucumberHooks {

    @After
    public void takeScreenshotWhenFail(Scenario scenario){
        ScreenshotHelper.takeScreenshotWhenFails(scenario);
    }
}