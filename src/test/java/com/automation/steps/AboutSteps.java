package com.automation.steps;

import com.automation.pages.AboutPage;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class AboutSteps {
    AboutPage aboutPage=new AboutPage();

    @Then("verify user is on about page")
    public void verifyUserIsOnAboutPage() {
        Assert.assertTrue(aboutPage.isAboutPageDisplayed());
    }
}
