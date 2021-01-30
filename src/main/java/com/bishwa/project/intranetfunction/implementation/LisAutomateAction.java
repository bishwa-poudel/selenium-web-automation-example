package com.bishwa.project.intranetfunction.implementation;

import com.bishwa.project.intranetfunction.specification.IAutomate;
import com.bishwa.project.intranetfunction.specification.IWebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Author: Bishwa
 * Date: 30/01/2021
 * Time: 15:11
 */
public abstract class LisAutomateAction implements IAutomate {
    protected WebDriver driver;

    public LisAutomateAction(IWebDriver webDriver) {
        this.driver = webDriver.getDriver();
    }

    public void execute() {
        try {
            login();
            action();
        } finally {
            close();
        }
    }

    protected abstract void action();

    protected void login() {
        driver.get("http://intranet.lisnepal.com.np/");

        WebElement userField = driver.findElement(By.id("usr-name"));
        WebElement passwordField = driver.findElement(By.id("usr-password"));
        WebElement submitButton = driver.findElement(By.className("login-btn"));

        userField.sendKeys("bishwa.poudel");
        passwordField.sendKeys("LuPmDZ5RbUKaDBD");
        submitButton.click();

        driver.get("http://login.lisnepal.com.np/home/");

        new WebDriverWait(driver, 1)
                .until(ExpectedConditions.visibilityOf(driver.findElement(By.className("user-name-top"))));

        System.out.println("Logged in to LIS Intranet");
    }

    protected void close() {
        driver.quit();
    }
}
