package com.automation.utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtil {

    public static byte[] attachScreenShot(WebDriver driver){
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        return takesScreenshot.getScreenshotAs(OutputType.BYTES);
    }
}
