package com.automation.steps;

import com.automation.pages.CheckoutPage;
import com.automation.utils.ConfigReader;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class CheckoutSteps {

    CheckoutPage checkoutPage=new CheckoutPage();

    @Then("verify user is on checkout page")
    public void verify_user_is_on_checkout_page() {
        Assert.assertTrue(checkoutPage.isCheckoutPageDisplayed());
       
    }

    @When("user fill all checkout details {string} {string} {string}")
    public void user_fill_all_checkout_details(String firstname, String lastname, String zipcode) {
        checkoutPage.fillShippingInfo(ConfigReader.getConfigValue(firstname),ConfigReader.getConfigValue(lastname),ConfigReader.getConfigValue(zipcode));
       
    }

    @When("click on Continue button")
    public void click_on_continue_button() {
        checkoutPage.clickOnContinueBtn();
    }


    @Then("verify error message displayed")
    public void verifyErrorMessageDisplayed() {
        Assert.assertTrue(checkoutPage.isErrorDisplayed());
    }
}
