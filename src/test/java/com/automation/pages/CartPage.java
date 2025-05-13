package com.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.time.Duration;
import java.util.List;

public class CartPage extends BasePage{

    @FindBy(id = "remove-sauce-labs-backpack")
    List<WebElement> removeBtnList;

    @FindBy(css = ".cart_item_label")
    List<WebElement> cartItems;

    @FindBy(id = "checkout")
    WebElement checkoutBtn;

    public void clickOnRemoveBtn(){
        removeBtnList.getFirst().click();
    }

    public boolean isCartPageDisplayed(){
        return checkoutBtn.isDisplayed();
    }

    public boolean isProductRemovedSuccessfully(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        return removeBtnList.isEmpty();
    }

    public void clickOnCheckoutBtn(){
        checkoutBtn.click();
    }

}
