package com.automation.steps;

import com.automation.pages.OrderConfirmationPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class OrderConfirmationSteps {

    OrderConfirmationPage orderConfirmationPage=new OrderConfirmationPage();

    @Then("verify user is on order confirmation page")
    public void verify_user_is_on_order_confirmation_page() {
        Assert.assertTrue(orderConfirmationPage.isOrderConfirmationMsgDisplayed());
    }

    @When("user click on back home button")
    public void userClickOnBackHomeButton() {
        orderConfirmationPage.clickOnBackBtn();
    }
}
