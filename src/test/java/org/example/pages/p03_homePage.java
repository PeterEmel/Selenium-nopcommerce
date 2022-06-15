package org.example.pages;

import org.example.stepDefinitions.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class p03_homePage {

    //Currency Check

    public WebElement currencyDropList() { return Hooks.driver.findElement(By.name("customerCurrency")); }

    public List<WebElement> productsPrices() { return Hooks.driver.findElements(By.cssSelector("span[class=\"price actual-price\"]")); }



    //Search Web Elements

    public WebElement search() { return Hooks.driver.findElement(By.xpath("//input[@class=\"search-box-text ui-autocomplete-input\"]")); }

    public WebElement searchBtn() { return Hooks.driver.findElement(By.cssSelector("button[class=\"button-1 search-box-button\"]")); }

    public List<WebElement> availProducts() { return Hooks.driver.findElements(By.cssSelector("div[class=\"item-box\"]")); }

    public WebElement skuProduct() { return Hooks.driver.findElement(By.cssSelector("div[class=\"item-box\"]")); }

    public WebElement productDetailsSku() { return Hooks.driver.findElement(By.cssSelector("div[class=\"sku\"] [class=\"value\"]")); }



    // Hover and select Categories

    public List<WebElement> categories() { return Hooks.driver.findElements(By.xpath("//ul[@class=\"top-menu notmobile\"]/li")); }

    public WebElement pageTitle() { return Hooks.driver.findElement(By.cssSelector("div[class=\"page-title\"] h1")); }



    // Home Sliders

    public WebElement sliders(String num) { return Hooks.driver.findElement(By.cssSelector("a[class=\"nivo-imageLink\"]:nth-child("+num+")")); }



    // Follow Us Buttons

    public WebElement facebookBtn() { return Hooks.driver.findElement(By.cssSelector("a[href=\"http://www.facebook.com/nopCommerce\"]")); }
    public WebElement twitterBtn() { return Hooks.driver.findElement(By.cssSelector("a[href=\"https://twitter.com/nopCommerce\"]")); }
    public WebElement rssBtn() { return Hooks.driver.findElement(By.cssSelector("a[href=\"/news/rss/1\"]")); }
    public WebElement youtubeBtn() { return Hooks.driver.findElement(By.cssSelector("a[href=\"http://www.youtube.com/user/nopCommerce\"]")); }


    // Wishlist Buttons

    public List<WebElement> wishlistBtns() { return Hooks.driver.findElements(By.cssSelector("button[class=\"button-2 add-to-wishlist-button\"]")); }

    public WebElement successMsg() { return Hooks.driver.findElement(By.cssSelector("div[class=\"bar-notification success\"]")); }
    public WebElement successMsgContent() { return Hooks.driver.findElement(By.cssSelector("p[class=\"content\"]")); }

    public WebElement wishlistQty() { return Hooks.driver.findElement(By.cssSelector("span[class=\"wishlist-qty\"]")); }
    public WebElement wishlistPageBtn() { return Hooks.driver.findElement(By.className("ico-wishlist")); }

}
