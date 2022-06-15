package org.example.stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.p03_homePage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class D06_homeSlidersStepDef {

    p03_homePage homePage = new p03_homePage();


    // First Scenario

    @When("First Slider is clicked")
    public void firstSliderSelected() { homePage.sliders("1").click(); }

    @Then("Relative product for first slider is displayed")
    public void firstSliderPageAssertion() {
            // To create explicit wait condition, you need to create new object from WebDriverWait class then call your expected conditions as shown below
            WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(10));
            boolean check =  wait.until(ExpectedConditions.urlContains("https://demo.nopcommerce.com/nokia-lumia-1020"));
            Assert.assertTrue(check);
    }



    // Second Scenario

    @When("Second Slider is clicked")
    public void secondSliderSelected() { homePage.sliders("2").click(); }

    @Then("Relative product for second slider is displayed")
    public void secondSliderPageAssertion() {
        // To create explicit wait condition, you need to create new object from WebDriverWait class then call your expected conditions as shown below
        WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(10));
        boolean check =  wait.until(ExpectedConditions.urlContains("https://demo.nopcommerce.com/iphone-6"));
        Assert.assertTrue(check);
    }

}
