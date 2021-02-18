package com.bishwa.project.lis.core.lisautomateactions;

import com.bishwa.project.lis.core.specification.IAutomate;
import com.bishwa.project.lis.core.specification.IDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
    private static final Logger logger = LogManager.getLogger(LisAutomateAction.class);

    private static final String INTRANET_LOGIN_URL = "http://login.lisnepal.com.np/home/";
    private static final String INTRANET_HOME_URL = "http://login.lisnepal.com.np/home/login";
    public static final String INTRANET_USERNAME = "bishwa.poudel";
    public static final String INTRANET_PASSWORD = "LuPmDZ5RbUKaDBD";

    protected WebDriver driver;

    public LisAutomateAction(IDriverManager webDriver) {
        this.driver = webDriver.getDriver();
    }

    public void execute() {
        login();
        action();
    }

    protected abstract void action();

    protected void login() {
        if(checkIfLoggedIn()) {
            logger.info("Already logged in to LIS Intranet");
           return;
        }

        WebElement userField = driver.findElement(By.id("usr-name"));
        WebElement passwordField = driver.findElement(By.id("usr-password"));
        WebElement submitButton = driver.findElement(By.className("login-btn"));

        userField.sendKeys(INTRANET_USERNAME);
        passwordField.sendKeys(INTRANET_PASSWORD);
        submitButton.click();

        driver.get(INTRANET_LOGIN_URL);

        new WebDriverWait(driver, 1)
                .until(ExpectedConditions.visibilityOf(driver.findElement(By.className("user-name-top"))));

        logger.info("Logged in to LIS Intranet");
    }

    private boolean checkIfLoggedIn() {
        driver.get(INTRANET_HOME_URL);

        List<WebElement> loggedInElements = driver.findElements(By.className("user-name-top"));

        return !loggedInElements.isEmpty();
    }

    @PreDestroy
    protected void close() {
        logger.info("Closing driver connection...");
        driver.quit();
    }
}
