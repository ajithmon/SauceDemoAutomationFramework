package com.automation.steps;

import com.automation.pages.HomePage;
import com.automation.utils.ConfigReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.bytebuddy.implementation.auxiliary.MethodCallProxy;
import org.junit.Assert;

public class HomeSteps {

    HomePage homePage=new HomePage();

    @Then("verify user is on home page")
    public void verify_user_is_on_home_page() {
        Assert.assertTrue(homePage.isHomePageDisplayed());
    }

    @When("user add a product {string} to cart")
    public void userAddAProductToCart(String product) {
        homePage.userAddProductToCart(ConfigReader.getConfigValue(product));
    }

    @Then("verify cart quantity got updated")
    public void verifyCartQuantityGotUpdated() {
        Assert.assertEquals(homePage.getCartQuantity(),1);
    }

    @When("user click on cart icon")
    public void userClickOnCartIcon() {
        homePage.clickOnCartIcon();
    }

    @When("user click on a product")
    public void userClickOnAProduct() {
        homePage.userClickOnProduct();
    }

    @Then("verify product details are displayed")
    public void verifyProductDetailsAreDisplayed() {
        Assert.assertTrue(homePage.verifyProductDetails());
    }

    @When("user click on {string} from sort options")
    public void userClickOnSortOptions(String option) {
        homePage.selectCategory(option);
    }

    @Then("verify product sorted by {string}")
    public void verifyProductSortedByOption(String option) {
        Assert.assertTrue(homePage.isProductsSortBY(option));
    }

    @When("user open side menu and click {string} option")
    public void userOpenSideMenuAndClickOption(String option) {
        homePage.selectSideMenuOption(option);
    }

    @Then("verify cart becomes empty and app got reset")
    public void verifyCartBecomesEmptyAndAppGotReset() {
        Assert.assertTrue(homePage.isCartBecomesEmpty());
    }

    @When("user add multiple products to cart")
    public void userAddMultipleProductsToCart() {
        homePage.addMultipleProducts();
    }

    @Then("verify cart showing correct quantity")
    public void verifyCartShowingCorrectQuantity() {
        Assert.assertEquals(homePage.getCartQuantity(),Integer.parseInt(ConfigReader.getConfigValue("count")));
    }

    @Then("verify product image is displayed correctly")
    public void verifyProductImageIsDisplayedCorrectly() {
        Assert.assertTrue(homePage.isProductImageVisible());
    }
}
