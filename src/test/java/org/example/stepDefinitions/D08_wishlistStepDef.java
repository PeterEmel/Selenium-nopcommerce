package org.example.stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.p03_homePage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class D08_wishlistStepDef {

    p03_homePage homepage = new p03_homePage();


    // First Scenario

    @When("User clicks on add to wishlist button")
    public void wishlistBtnClicked() { homepage.wishlistBtns().get(2).click();}

    @Then("success message {string} with green background color {string} will be displayed")
    public void successMsgAssertion(String msgContent, String backgroundColor) {

        SoftAssert soft = new SoftAssert();

        // Success message is displayed assertion
        soft.assertTrue(homepage.successMsg().isDisplayed());

        // Message content assertion
        soft.assertEquals(homepage.successMsgContent().getText(), msgContent);

        // Background color assertion
        soft.assertEquals(homepage.successMsg().getCssValue("background-color"), backgroundColor);
    }


    // Second Scenario

    @When("User clicks on product wishlist button")
    public void addedToWishlistClicked() { homepage.wishlistBtns().get(2).click(); }


    @And("User is redirected to wishlist page after success message disappear")
    public void goToWishlistPage() {

        WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.invisibilityOf(homepage.successMsg()));

        homepage.wishlistPageBtn().click();

    }

    @Then("The added product is displayed in the wishlist page")
    public void productAddedAssertion() {

        SoftAssert soft = new SoftAssert();

        // Wishlist is not empty assertion

        String qtyString = homepage.wishlistQty().getText();
        int qty = Integer.parseInt(qtyString.substring(1,qtyString.length() - 1));
        System.out.println("Items in wishlist = " + qty);
        soft.assertTrue(qty > 0);

    }

}
