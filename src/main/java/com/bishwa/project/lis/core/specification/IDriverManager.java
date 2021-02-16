package com.bishwa.project.lis.core.specification;

import org.openqa.selenium.WebDriver;

import java.util.Objects;

/**
 * Author: Bishwa
 * Date: 30/01/2021
 * Time: 13:12
 */
public abstract class IDriverManager {
    protected static WebDriver webDriver;

    public IDriverManager() {
        this.setupDriver();
        this.initDriver();
    }

    public WebDriver getDriver() {
        return webDriver;
    };

    abstract protected void setupDriver();

    abstract protected void initDriver();

    public void tearDown() {
        if(Objects.nonNull(webDriver)) webDriver.quit();
    }
}
