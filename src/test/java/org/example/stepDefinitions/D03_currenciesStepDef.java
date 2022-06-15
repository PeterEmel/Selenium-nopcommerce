package org.example.stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.p03_homePage;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.concurrent.ThreadLocalRandom;

public class D03_currenciesStepDef {

    p03_homePage homePage = new p03_homePage();

    int randomCurrency = ThreadLocalRandom.current().nextInt(0,2);


    @When("User select random currency")
    public void selectCurrency() {
        Select selectCurrency = new Select(homePage.currencyDropList());
        selectCurrency.selectByIndex(randomCurrency);
    }

    @Then("currency is changed in Home Page correctly")
    public void assertAppliedCurrency() {

        int size = homePage.productsPrices().size();
        String selectedCurrency = "$";

        if (randomCurrency == 1 ) {
            selectedCurrency = "€";
        }

        //Assert list is not empty
        Assert.assertFalse(homePage.productsPrices().isEmpty());

        //Assert that price contains currency
        for (int i=0; i<size; i++) {
            Assert.assertTrue(homePage.productsPrices().get(i).getText().contains(selectedCurrency));
        }


    }
}
