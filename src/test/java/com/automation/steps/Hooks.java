package com.automation.steps;

import com.automation.utils.ConfigReader;
import com.automation.utils.DriverManager;
import com.automation.utils.ScreenshotUtil;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {

    @Before
    public void setUp(){
        ConfigReader.initConfig();
        DriverManager.createDriver();

    }

    @After
    public void cleanUp(Scenario scenario){
        if (scenario.isFailed()) {
        scenario.attach(ScreenshotUtil.attachScreenShot(DriverManager.getDriver()),"image/png","screenshot");
        System.out.println("Test Failed : "+scenario.getName());
    }
        DriverManager.getDriver().close();
    }

}
