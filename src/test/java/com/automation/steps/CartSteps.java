package com.automation.steps;

import com.automation.pages.CartPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class CartSteps {

    CartPage cartPage=new CartPage();

    @And("user click on remove button")
    public void userClickOnRemoveButton() {
        cartPage.clickOnRemoveBtn();
    }

    @Then("verify product removed from cart successfully")
    public void verifyProductRemovedFromCartSuccessfully() {
        Assert.assertTrue(cartPage.isProductRemovedSuccessfully());
    }

    @Then("verify user is on cart page")
    public void verifyUserIsOnCartPage() {
        Assert.assertTrue(cartPage.isCartPageDisplayed());
    }

    @When("user click on checkout button")
    public void userClickOnCheckoutButton() {
        cartPage.clickOnCheckoutBtn();
    }
}
