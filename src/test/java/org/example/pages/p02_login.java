package org.example.pages;

import org.example.stepDefinitions.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class p02_login {

    public WebElement loginPageBtn() { return Hooks.driver.findElement(By.cssSelector("a[class=\"ico-login\"]")); }

    public WebElement email() { return Hooks.driver.findElement(By.cssSelector("input[class=\"email\"]")); }

    public WebElement password() { return Hooks.driver.findElement(By.id("Password")); }

    public WebElement loginBtn() { return Hooks.driver.findElement(By.cssSelector("button[class=\"button-1 login-button\"]"));}

    public WebElement myAccount() { return Hooks.driver.findElement(By.cssSelector("a[class=\"ico-account\"]"));}
}
