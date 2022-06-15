package org.example.stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.p03_homePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;


public class D05_hoverCategoriesStepDef {

    p03_homePage homePage = new p03_homePage();

    String categoryName;
    String subCategoryName;
    String pageTitle;
    Boolean hasSubCategory;

    @When("User hovers on category and select subcategory")
    public void selectCategories() {
        Actions action = new Actions(Hooks.driver);

        Hooks.driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        int categoriesCount = homePage.categories().size();
        System.out.println("No of Categories " + categoriesCount);

        int randomCategory = ThreadLocalRandom.current().nextInt(0,categoriesCount);
        WebElement selectedCategory = homePage.categories().get(randomCategory);

        categoryName = selectedCategory.getText().toLowerCase().trim();
        System.out.println("Selected Category " + categoryName);

        action.moveToElement(selectedCategory).perform();

        List<WebElement> subCategories =  homePage.categories().get(randomCategory).findElements(By.cssSelector("[class=\"sublist first-level\"] a"));
        int subCategoriesCount = subCategories.size();



        if (subCategoriesCount > 0) {
            int randomSubCategory = ThreadLocalRandom.current().nextInt(0,subCategoriesCount);
            WebElement selectedSubCategory = subCategories.get(randomSubCategory);
            subCategoryName = selectedSubCategory.getText().toLowerCase().trim();
            System.out.println("Selected SubCategory " + subCategoryName);

            System.out.println("sublist Size: " + subCategoriesCount);
            selectedSubCategory.click();
            hasSubCategory = true;
        } else {
            selectedCategory.click();
            hasSubCategory = false;
        }


        pageTitle = homePage.pageTitle().getText().toLowerCase().trim();
        System.out.println("Page Title: " + homePage.pageTitle().getText().toLowerCase().trim());
        Hooks.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @Then("User should be redirected to the chosen category or subcategory")
    public void categoriesAssertion() {

        //Category name is the same as page title assertion
        if (hasSubCategory) {
            Assert.assertEquals(subCategoryName, pageTitle);
        } else {
            Assert.assertEquals(categoryName, pageTitle);
        }

    }


}
