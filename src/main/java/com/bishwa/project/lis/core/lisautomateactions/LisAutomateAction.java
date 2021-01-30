package com.bishwa.project.lis.core.lisautomateactions;

import com.bishwa.project.lis.core.specification.IAutomate;
import com.bishwa.project.lis.core.specification.IWebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.annotation.PreDestroy;
import java.util.List;

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
        login();
        action();
    }

    protected abstract void action();

    protected void login() {
        if(checkIfLoggedIn()) {
            System.out.println("Already logged in to LIS Intranet");
           return;
        }

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

    private boolean checkIfLoggedIn() {
        driver.get("http://login.lisnepal.com.np/home/login");

        List<WebElement> loggedInElements = driver.findElements(By.className("user-name-top"));

        return !loggedInElements.isEmpty();
    }

    @PreDestroy
    protected void close() {
        System.out.println("Closing driver connection...");
        driver.quit();
    }
}
