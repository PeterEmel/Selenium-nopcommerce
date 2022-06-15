package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.example.stepDefinitions.Hooks;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.ThreadLocalRandom;

public class p01_register {

    public WebElement registerTab()
    {
        return Hooks.driver.findElement(By.className("ico-register"));
    }


    public WebElement genderType(String type)
    {
        WebElement element = null;

        if (type.equals("male")) {
            element = Hooks.driver.findElement(By.id("gender-male"));
        }
        else if(type.contains("female")) {
            element = Hooks.driver.findElement(By.id("gender-female"));

        }
        return element;
    }


    public WebElement firstName() { return Hooks.driver.findElement(By.id("FirstName")); }
    public WebElement lastName() { return Hooks.driver.findElement(By.id("LastName")); }

    public WebElement dayList() { return Hooks.driver.findElement(By.name("DateOfBirthDay")); }
    public WebElement monthList() { return Hooks.driver.findElement(By.name("DateOfBirthMonth")); }
    public WebElement yearList() { return Hooks.driver.findElement(By.name("DateOfBirthYear")); }

    public WebElement email() { return Hooks.driver.findElement(By.id("Email")); }

    public WebElement password() { return Hooks.driver.findElement(By.id("Password")); }
    public WebElement confirmPassword() { return Hooks.driver.findElement(By.id("ConfirmPassword")); }

    public WebElement registerBtn() { return Hooks.driver.findElement(By.cssSelector("button[class=\"button-1 register-next-step-button\"]")); }

    public WebElement registrationCompletedMsg() { return Hooks.driver.findElement(By.cssSelector("div[class=\"result\"]")); }



}
