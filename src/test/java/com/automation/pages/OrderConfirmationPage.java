package com.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrderConfirmationPage extends BasePage{

    @FindBy(css = ".complete-header")
    WebElement orderConfirmationMsg;

    @FindBy(xpath = "//button[text()='Back Home']")
    WebElement backBtn;

    public boolean isOrderConfirmationMsgDisplayed() {
        return orderConfirmationMsg.isDisplayed();
    }

    public void clickOnBackBtn(){
        backBtn.click();
    }
}
