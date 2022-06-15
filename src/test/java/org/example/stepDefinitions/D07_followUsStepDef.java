package org.example.stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.p03_homePage;
import org.testng.Assert;

import java.util.ArrayList;

public class D07_followUsStepDef {

    p03_homePage homePage = new p03_homePage();

    // Facebook Scenario

    @When("User opens Facebook link")
    public void clickFacebook() { homePage.facebookBtn().click(); }

    @Then("{string} opens Facebook page in new tab")
    public void facebookPageOpenedAssertion(String url) {
        ArrayList<String> Tabs = new ArrayList<>(Hooks.driver.getWindowHandles());
        Hooks.driver.switchTo().window(Tabs.get(1));

        System.out.println(url);
        System.out.println(Hooks.driver.getCurrentUrl());
        System.out.println(Hooks.driver.getTitle());

        Assert.assertEquals(Hooks.driver.getCurrentUrl(),url);

        Hooks.driver.close();
        Hooks.driver.switchTo().window(Tabs.get(0));

        System.out.println(Hooks.driver.getCurrentUrl());
        System.out.println(Hooks.driver.getTitle());
    }


    // Twitter Scenario

    @When("User opens Twitter link")
    public void clickTwitter() { homePage.twitterBtn().click(); }

    @Then("{string} opens Twitter page in new tab")
    public void twitterPageOpenedAssertion(String url) throws InterruptedException {

        Thread.sleep(2000);

        ArrayList<String> Tabs = new ArrayList<>(Hooks.driver.getWindowHandles());
        Hooks.driver.switchTo().window(Tabs.get(1));

        System.out.println(url);
        System.out.println(Hooks.driver.getCurrentUrl());

        Assert.assertEquals(Hooks.driver.getCurrentUrl(),url);

        Hooks.driver.close();
        Hooks.driver.switchTo().window(Tabs.get(0));
    }

    // rss Scenario

    @When("User opens rss link")
    public void clickRss() { homePage.rssBtn().click(); }

    @Then("{string} opens rss page in new tab")
    public void rssPageOpenedAssertion(String url) throws InterruptedException {

        Thread.sleep(2000);

        ArrayList<String> Tabs = new ArrayList<>(Hooks.driver.getWindowHandles());
        Hooks.driver.switchTo().window(Tabs.get(1));

        System.out.println(url);
        System.out.println(Hooks.driver.getCurrentUrl());

        Assert.assertEquals(Hooks.driver.getCurrentUrl(),url);

        Hooks.driver.close();
        Hooks.driver.switchTo().window(Tabs.get(0));
    }


    // Youtube Scenario

    @When("User opens Youtube link")
    public void clickYoutube() { homePage.youtubeBtn().click(); }

    @Then("{string} opens Youtube page in new tab")
    public void youtubePageOpenedAssertion(String url) throws InterruptedException {

        Thread.sleep(2000);

        ArrayList<String> Tabs = new ArrayList<>(Hooks.driver.getWindowHandles());
        Hooks.driver.switchTo().window(Tabs.get(1));

        System.out.println(url);
        System.out.println(Hooks.driver.getCurrentUrl());

        Assert.assertEquals(Hooks.driver.getCurrentUrl(),url);

        Hooks.driver.close();
        Hooks.driver.switchTo().window(Tabs.get(0));
    }
}
