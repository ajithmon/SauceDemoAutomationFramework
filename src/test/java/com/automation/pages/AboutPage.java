package com.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AboutPage extends BasePage{

    @FindBy(xpath = "//button[text()='Try it free']")
    WebElement tryItFreeBtn;

    public boolean isAboutPageDisplayed(){
        return tryItFreeBtn.isDisplayed();
    }
}
