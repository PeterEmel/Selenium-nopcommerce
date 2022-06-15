package org.example.stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.p03_homePage;
import org.testng.asserts.SoftAssert;

public class D04_searchStepDef {

    p03_homePage homepage = new p03_homePage();

    public String enteredSku = "null";

    // First Scenario: Search By Product Name

    @When("User search for a product e.g. {string}")
    public void searchProduct(String enteredText) { homepage.search().sendKeys(enteredText);}

    @And("User Clicks on Search Button")
    public void ClickSearchBtn() { homepage.searchBtn().click();}

    @Then("Website will show the products related to search")
    public void assertSearchResults() {

        SoftAssert soft = new SoftAssert();

        // URL Assertion
        String url = Hooks.driver.getCurrentUrl();
        Boolean urlCheck = url.contains("https://demo.nopcommerce.com/search?q=");
        soft.assertTrue(urlCheck);

        // Assertion that products appeared by counting elements appeared from search
        soft.assertTrue(homepage.availProducts().size()>0);

        soft.assertAll();
    }


    // Second Scenario: Search By Product SKU

    @When("User search for a product by SKU e.g. {string}")
    public void searchProductSKU(String enteredText) {
        homepage.search().sendKeys(enteredText);
        enteredSku = enteredText;
    }


    @And("User Clicks on Search Button again")
    public void ClickSearchBtnSKU() { homepage.searchBtn().click();}

    @Then("Website will show the products related to search SKU")
    public void assertSearchResultsSKU() {

        SoftAssert soft = new SoftAssert();

        // URL Assertion
        String url = Hooks.driver.getCurrentUrl();
        Boolean urlCheck = url.contains("https://demo.nopcommerce.com/search?q=");
        soft.assertTrue(urlCheck);

        // Assert that product appeared has the same SKU number
        homepage.skuProduct().click();
        String selectedProductSKu = homepage.productDetailsSku().getText();
        soft.assertEquals(selectedProductSKu, enteredSku);


        soft.assertAll();
    }
}
