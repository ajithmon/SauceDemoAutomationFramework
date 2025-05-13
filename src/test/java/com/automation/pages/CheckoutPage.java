package com.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutPage extends BasePage {

    @FindBy(id = "continue")
    WebElement continueBtn;

    @FindBy(id = "postal-code")
    WebElement zipCodeInput;

    @FindBy(id = "last-name")
    WebElement lastNameInput;

    @FindBy(id = "first-name")
    WebElement firstNameInput;

    @FindBy(css = ".error h3")
    WebElement errorMsg;

    public boolean isCheckoutPageDisplayed() {
        return continueBtn.isDisplayed();
    }

    public void fillShippingInfo(String firstname,String lastname,String zipcode) {
        firstNameInput.sendKeys(firstname);
        lastNameInput.sendKeys(lastname);
        zipCodeInput.sendKeys(zipcode);
    }

    public void clickOnContinueBtn() {
        continueBtn.click();
    }

    public boolean isErrorDisplayed(){
        return errorMsg.isDisplayed();
    }
}
