package org.example.stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.p01_register;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.ThreadLocalRandom;

public class D01_registerStepDef {

    p01_register register = new p01_register();

    @Given("user go to register page")
    public void goRegisterPage()
    {
        register.registerTab().click();
    }

    @When("user choose gender type")
    public void genderType()
    {
        register.genderType("female").click();
    }

    @And("User enters first name {string} and last name {string}")
    public void enterFirstName(String firstName, String lastName) {
        register.firstName().sendKeys(firstName);
        register.lastName().sendKeys(lastName);
    }

    @And ("User enters date of birth")
    public void enterBirthdayDate() {
        //To select day using selenium select class
        int randomDay = ThreadLocalRandom.current().nextInt(1,31);
        Select selectDay = new Select(register.dayList());
        selectDay.selectByIndex(randomDay);

        int randomMonth = ThreadLocalRandom.current().nextInt(1,12);
        Select selectMonth = new Select(register.monthList());
        selectMonth.selectByIndex(randomMonth);

        Select selectYear = new Select(register.yearList());
        selectYear.selectByValue("1995");
        }

    @And("User Enter email {string}")
    public void enterEmail (String email) { register.email().sendKeys(email); }

    @And("user fills password field {string} and confirm the password")
    public void enterPassword(String password) {
        register.password().sendKeys(password);
        register.confirmPassword().sendKeys(password);
    }

    @And("User clicks on register button")
    public void clickRegister() { register.registerBtn().click();}


    @Then("Success message is displayed")
    public void assertUserRegistered() {

        SoftAssert soft = new SoftAssert();

        //Url Assertion
        soft.assertEquals(Hooks.driver.getCurrentUrl(), "https://demo.nopcommerce.com/registerresult/1?returnUrl=/");

        // Registration msg assertion
        soft.assertEquals(register.registrationCompletedMsg().getText(), "Your registration completed");

        //Text color is Green assertion
        String textColor = register.registrationCompletedMsg().getCssValue("color");
        soft.assertEquals(textColor, "rgba(76, 177, 124, 1)");

        soft.assertAll();
    }
}
