package org.example.stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.p02_login;
import org.testng.asserts.SoftAssert;

public class D02_loginStepDef {
    p02_login login = new p02_login();

    @Given("User is in login page")
    public void clickLogin() { login.loginPageBtn().click();}

    @When("User enters valid email {string} and valid password {string}")
    public void loginData(String email, String password) {
        login.email().sendKeys(email);
        login.password().sendKeys(password);
    }

    @And("User clicks on login button")
    public void login() {login.loginBtn().click();}

    @Then("User logs in")
    public void assertLogin() {

        SoftAssert soft = new SoftAssert();

        //Url Assertion
        soft.assertEquals(Hooks.driver.getCurrentUrl(), "https://demo.nopcommerce.com/");

        // My account tab is displayed Assertion
        System.out.println(login.myAccount().isDisplayed());
        soft.assertTrue(login.myAccount().isDisplayed());

        soft.assertAll();
    }
}
